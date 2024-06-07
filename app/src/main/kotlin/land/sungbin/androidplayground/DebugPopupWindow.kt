@file:Suppress("INVISIBLE_REFERENCE", "INVISIBLE_MEMBER", "EXPOSED_PARAMETER_TYPE")

package land.sungbin.androidplayground

import android.graphics.Canvas
import android.view.Gravity
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.PopupWindow
import androidx.annotation.MainThread
import androidx.compose.runtime.snapshots.ObserverHandle
import androidx.compose.runtime.snapshots.Snapshot
import androidx.compose.runtime.snapshots.StateObject
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.TextMeasurer
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.drawText
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.IntRect
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.roundToIntRect
import androidx.compose.ui.unit.toSize
import androidx.compose.ui.util.fastForEach
import androidx.compose.ui.util.fastMap
import androidx.compose.ui.util.fastMaxOfOrNull
import androidx.compose.ui.util.fastSumBy
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.findViewTreeLifecycleOwner
import kotlin.math.max
import kotlin.math.roundToInt
import androidx.compose.ui.graphics.Canvas as DslCanvas

class DebugPopupWindow internal constructor() : PopupWindow() {
  private var anchor: DebugComposeView? = null
  private var contentView: DebugPopupView? = null
  private var currentWatcherDisposeHandle: ObserverHandle? = null

  private val textMeasurer by lazy {
    val owner = requireOwner()
    TextMeasurer(
      defaultFontFamilyResolver = owner.fontFamilyResolver,
      defaultDensity = owner.density,
      defaultLayoutDirection = owner.layoutDirection,
      cacheSize = DEFAULT_CACHE_SIZE,
    )
  }
  private var windowSize = IntSize.Zero

  private var target: Pair<Rect, DebugData>? = null

  @MainThread
  fun start(host: DebugComposeView) {
    anchor = host
    contentView = DebugPopupView(host).also(::setContentView)

    currentWatcherDisposeHandle = Snapshot.registerApplyObserver { changes, _ ->
      val contentView = contentView ?: return@registerApplyObserver
      if (changes.isRealChanged()) {
        target = host.debugData.value
        val target = target
        println("Detect target $target")
        if (target != null) {
          val previousUiSize = contentView.current?.size
          val ui = contentView.calculateUi(target)
          println("ui result: $ui, previousUiSize: $previousUiSize")
          contentView.layoutParams = ViewGroup.LayoutParams(ui.size.width, ui.size.height)
          if (previousUiSize != ui.size) contentView.requestLayout() else contentView.invalidate()
          println("content size is ${contentView.width}x${contentView.height}")
          println("content visiblility is ${contentView.visibility}")
          println("contet willNotDraw is ${contentView.willNotDraw()}")
          ui.popupPosition.let { pos ->
            if (isShowing) update(pos.x, pos.y, ui.size.width, ui.size.height, /* force = */ true)
            else showAtLocation(/* parent = */ host, Gravity.NO_GRAVITY, pos.x, pos.y)
          }
          println("show! $isShowing, content ${getContentView()}")
        } else {
          println("dismiss!")
          dismiss()
        }
      }
    }

    host.findViewTreeLifecycleOwner()!!.lifecycle.addObserver(object : DefaultLifecycleObserver {
      // Clean up DebugView to match when Recomposer cancel.
      // https://cs.android.com/androidx/platform/frameworks/support/+/androidx-main:compose/ui/ui/src/androidMain/kotlin/androidx/compose/ui/platform/WindowRecomposer.android.kt;l=417-419;drc=dcaa116fbfda77e64a319e1668056ce3b032469f
      override fun onDestroy(owner: LifecycleOwner) {
        release()
      }
    })
  }

  private fun release() {
    currentWatcherDisposeHandle?.dispose()
    contentView?.release()
    contentView = null // TODO don't have any additional resources to clean up?
    anchor = null
  }

  @Suppress("NOTHING_TO_INLINE")
  private inline fun requireOwner() =
    checkNotNull(anchor?.owner) { "DebugPopupWindow is not started" }

  @Suppress("NOTHING_TO_INLINE")
  private inline fun Set<Any>.isRealChanged() = anchor!!.debugData as StateObject in this

  private inner class UiCache(
    val size: IntSize,
    val anchorBounds: IntRect,
    val title: TextLayoutResult?,
    val contents: List<TextLayoutResult>,
  ) {
    init {
      require(contents.isNotEmpty()) { "Expected 'contents' to be non-empty, but it is" }
    }

    // Use lazy calculation
    val popupPosition
      get() = DebugPopupPositionProvider.calculatePosition(
        anchorBounds = anchorBounds,
        windowSize = windowSize,
        layoutDirection = requireOwner().layoutDirection,
        popupContentSize = size,
      )

    override fun toString() =
      "UiCache(" +
        "size=$size, " +
        "anchorBounds=$anchorBounds, " +
        "popupPosition=$popupPosition, " +
        "title=${title?.layoutInput?.text}" +
        ")"
  }

  private inner class DebugPopupView(host: DebugComposeView) :
    View(host.context), Density by requireOwner().density {

    private val drawScope = CanvasDrawScope()

    @Volatile
    var current: UiCache? = null

    init {
      var startX = 0
      var startY = 0
      var offsetX: Int
      var offsetY: Int

      @Suppress("ClickableViewAccessibility") // DebugView does not handle click events.
      setOnTouchListener { _, event ->
        when (event.action) {
          MotionEvent.ACTION_DOWN -> {
            startX = event.x.roundToInt()
            startY = event.y.roundToInt()
          }
          MotionEvent.ACTION_MOVE -> {
            offsetX = event.rawX.roundToInt() - startX
            offsetY = event.rawY.roundToInt() - startY
            update(offsetX, offsetY, /* width = */ -1, /* height = */ -1, /* force = */ true)
          }
        }

        true
      }
    }

    override fun requestLayout() {
      println("requestLayout!")
      super.requestLayout()
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
      println("onLayout: $changed, $left, $top, $right, $bottom")
      super.onLayout(changed, left, top, right, bottom)
    }

    override fun invalidate() {
      println("invalidate!")
      println("content size is ${width}x${height}")
      println("content visiblility is $visibility (VISIBLE = ${VISIBLE})")
      println("contet willNotDraw is ${willNotDraw()}")
      super.invalidate()
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
      println("onSizeChanged: $w, $h, $oldw, $oldh")
      if (oldw == 0 || oldh == 0) invalidate()
      super.onSizeChanged(w, h, oldw, oldh)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
      val size = current?.size ?: IntSize.Zero
      println("onMeasure: $size")
      setMeasuredDimension(size.width, size.height)
    }

    override fun draw(canvas: Canvas) {
      println("draw!")
      super.draw(canvas)
    }

    override fun dispatchDraw(canvas: Canvas) {
      println("dispatchDraw!")
      super.dispatchDraw(canvas)
    }

    override fun onDraw(canvas: Canvas) {
      println("onDraw: $current")
      val current = current ?: return
      drawScope.draw(
        density = this,
        layoutDirection = requireOwner().layoutDirection,
        canvas = DslCanvas(canvas),
        size = current.size.toSize(),
      ) {
        drawRect(color = DEFAULT_BACKGROUND_COLOR)
        translate(left = DEBUG_VIEW_PADDING.toPx(), top = DEBUG_VIEW_PADDING.toPx()) {
          var y = 0f
          current.title?.let { drawText(it); y += it.size.height + DEBUG_VIEW_SPACING.toPx() }
          current.contents.fastForEach { content ->
            drawText(content, topLeft = Offset(x = 0f, y = y))
            y += content.size.height + DEBUG_VIEW_SPACING.toPx()
          }
        }
      }
    }

    fun calculateUi(target: Pair<Rect, DebugData>): UiCache {
      val (bounds, data) = target

      val title = if (data.name.isNotBlank()) textMeasurer.measure(text = data.name, style = DEBUG_TITLE_STYLE) else null
      val contents = data.contents.fastMap { textMeasurer.measure(text = it, style = DEBUG_CONTENT_STYLE) }

      val size = IntSize(
        width = 0
          // TODO fastMaxOfOrNull -> fastMaxOf (https://github.com/jisungbin/FastList/issues/3)
          .plus(max(title?.size?.width ?: 0, contents.fastMaxOfOrNull { it.size.width }!!))
          .plus(DEBUG_VIEW_PADDING.roundToPx() * 2),
        height = 0
          .plus(title?.size?.height ?: 0)
          .let { if (title != null) it + DEBUG_VIEW_SPACING.roundToPx() else it }
          .plus(contents.fastSumBy { it.size.height })
          .plus(DEBUG_VIEW_SPACING.roundToPx() * (contents.size - 1))
          .plus(DEBUG_VIEW_PADDING.roundToPx() * 2),
      )

      return UiCache(
        size = size,
        anchorBounds = bounds.roundToIntRect(),
        title = title,
        contents = contents,
      ).also {
        current = it
      }
    }

    fun release() {
      current = null
    }
  }

  private companion object {
    const val DEFAULT_CACHE_SIZE = 15
    val DEFAULT_BACKGROUND_COLOR = Color.Gray.copy(alpha = 0.8f)

    val DEBUG_VIEW_PADDING = 8.dp
    val DEBUG_VIEW_SPACING = 4.dp

    val DEBUG_TITLE_STYLE = TextStyle(fontWeight = FontWeight.Bold)
    val DEBUG_CONTENT_STYLE = TextStyle.Default
  }
}
