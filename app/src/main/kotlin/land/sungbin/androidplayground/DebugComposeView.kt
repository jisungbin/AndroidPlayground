@file:Suppress("INVISIBLE_REFERENCE", "INVISIBLE_MEMBER")

package land.sungbin.androidplayground

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.ViewGroup
import androidx.activity.ComponentActivity
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionContext
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.ObserverHandle
import androidx.compose.runtime.snapshots.Snapshot
import androidx.compose.runtime.snapshots.StateObject
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.node.Owner
import androidx.compose.ui.platform.AbstractComposeView
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.semantics.SemanticsNode
import androidx.compose.ui.semantics.getAllSemanticsNodes
import androidx.compose.ui.text.TextMeasurer
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.drawText
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.roundToIntRect
import androidx.compose.ui.unit.toSize
import androidx.compose.ui.util.fastForEach
import androidx.compose.ui.util.fastMap
import androidx.compose.ui.util.fastMaxOfOrNull
import androidx.compose.ui.util.fastSumBy
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.findViewTreeLifecycleOwner
import androidx.lifecycle.findViewTreeViewModelStoreOwner
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.lifecycle.setViewTreeLifecycleOwner
import androidx.lifecycle.setViewTreeViewModelStoreOwner
import androidx.savedstate.findViewTreeSavedStateRegistryOwner
import androidx.savedstate.setViewTreeSavedStateRegistryOwner
import kotlinx.coroutines.android.awaitFrame
import kotlinx.coroutines.awaitCancellation
import kotlinx.coroutines.launch
import kotlin.concurrent.thread
import kotlin.math.max

@Suppress("VisibleForTests")
class DebugComposeView(
  context: Context,
  attrs: AttributeSet? = null,
  defStyleAttr: Int = 0,
) : AbstractComposeView(context, attrs, defStyleAttr) {
  private var owner: Owner? = null
  private val textMeasurer by lazy {
    val owner = requireOwner()
    TextMeasurer(
      defaultFontFamilyResolver = owner.fontFamilyResolver,
      defaultDensity = owner.density,
      defaultLayoutDirection = owner.layoutDirection,
      cacheSize = DEFAULT_CACHE_SIZE,
    )
  }

  private val debugNodes = mutableStateMapOf<Int, SemanticsNode>()
  private val debugUi = mutableStateOf<DebugUiCache?>(null)

  private val content = mutableStateOf<(@Composable () -> Unit)?>(null)
  private var debugNodeCollectorThread: Thread? = null

  @Suppress("RedundantVisibilityModifier")
  protected override var shouldCreateCompositionOnAttachedToWindow: Boolean = false
    private set

  @Composable
  override fun Content() {
    content.value?.invoke()
  }

  override fun getAccessibilityClassName(): String = javaClass.name

  fun setContent(content: @Composable () -> Unit) {
    shouldCreateCompositionOnAttachedToWindow = true
    this.content.value = @Composable {
      // TODO [EQUALS_MISSING] No method 'equals(Any?): Boolean' available.. What??
      if (owner === null) owner = LocalView.current as Owner
      val owner = requireOwner()

      Box(
        modifier = Modifier
          .fillMaxSize()
          .then(if (DebugViewOptions.enabled) layoutBoundsDrawingModifier() else Modifier),
      ) {
        content()
        debugUi.value?.let { ui ->
          Canvas(
            modifier = Modifier
              .size(with(requireOwner().density) { ui.size.toDpSize() })
              .offset {
                ui.positionInRoot(
                  rootSize = IntSize(owner.root.width, owner.root.height),
                  density = requireOwner().density,
                )
              }
              .background(color = DEFAULT_BACKGROUND_COLOR),
          ) {
            translate(left = DEBUG_VIEW_PADDING.toPx(), top = DEBUG_VIEW_PADDING.toPx()) {
              var y = 0f
              ui.title?.let { drawText(it); y += it.size.height + DEBUG_VIEW_SPACING.toPx() }
              ui.contents.fastForEach { content ->
                drawText(content, topLeft = Offset(x = 0f, y = y))
                y += content.size.height + DEBUG_VIEW_SPACING.toPx()
              }
            }
          }
        }
        if (isAttachedToWindow) createComposition()
      }
    }
  }

  @Suppress("ModifierFactoryExtensionFunction")
  private fun layoutBoundsDrawingModifier() =
    Modifier.drawWithContent {
      drawContent()
      debugNodes.values.forEach { node ->
        drawRect(
          color = Color.Red,
          topLeft = node.positionInRoot,
          size = node.size.toSize(),
          style = Stroke(width = 1.dp.toPx()),
        )
      }
    }

  private fun calculateUi(bounds: Rect, data: DebugData): DebugUiCache {
    val title = if (data.name.isNotBlank()) textMeasurer.measure(text = data.name, style = DEBUG_TITLE_STYLE) else null
    val contents = data.contents.fastMap { textMeasurer.measure(text = it, style = DEBUG_CONTENT_STYLE) }

    val size = with(requireOwner().density) {
      Size(
        width = 0f
          // TODO fastMaxOfOrNull -> fastMaxOf (https://github.com/jisungbin/FastList/issues/3)
          .plus(max(title?.size?.width ?: 0, contents.fastMaxOfOrNull { it.size.width }!!))
          .plus(DEBUG_VIEW_PADDING.toPx() * 2),
        height = 0f
          .plus(title?.size?.height ?: 0)
          .let { if (title != null) it + DEBUG_VIEW_SPACING.toPx() else it }
          .plus(contents.fastSumBy { it.size.height })
          .plus(DEBUG_VIEW_SPACING.toPx() * (contents.size - 1))
          .plus(DEBUG_VIEW_PADDING.toPx() * 2),
      )
    }

    return DebugUiCache(
      size = size,
      anchorBounds = bounds.roundToIntRect(),
      title = title,
      contents = contents,
      source = data,
    ).also { ui ->
      debugUi.value = ui
    }
  }

  override fun onAttachedToWindow() {
    if (debugNodeCollectorThread != null) debugNodeCollectorThread!!.interrupt()
    var debugNodeCollectorDisposeHandle: ObserverHandle? = null
    debugNodeCollectorThread = thread(
      name = "DebugNodeCollector",
      isDaemon = true,
      priority = Thread.NORM_PRIORITY,
    ) {
      findViewTreeLifecycleOwner()!!.run {
        lifecycleScope.launch {
          println("onAttachedToWindow started!")
          try {
            repeatOnLifecycle(Lifecycle.State.CREATED) {
              println("onAttachedToWindow started! - 2")
              while (true) {
                awaitFrame()
                // TODO "===" -> "=="
                if (owner === null) {
                  println("'owner' is not initialized yet!")
                  continue
                }

                collectDebugNodesOrClearIfDestroyed()
                println("Collected ${debugNodes.size} debug nodes")
                break
              }

              debugNodeCollectorDisposeHandle = Snapshot.registerApplyObserver { changes, _ ->
                println("DebugComposeView registerApplyObserver: $changes")
                if (!changes.isRealChanged()) return@registerApplyObserver
                collectDebugNodesOrClearIfDestroyed()
                println("Re-collected ${debugNodes.size} debug nodes")
              }

              awaitCancellation()
            }
          } finally {
            debugNodeCollectorDisposeHandle?.dispose()
            debugNodes.clear()
            debugUi.value = null
            owner = null
            println("onAttachedToWindow finished!")
          }
        }
      }
    }
    super.onAttachedToWindow()
  }

  // TODO testing multi-window support
  override fun dispatchTouchEvent(event: MotionEvent): Boolean {
    println("action is ${event.action}")
    if (event.action == MotionEvent.ACTION_DOWN) {
      val offset = Offset(x = event.x, y = event.y)
      val target = debugNodes.values.firstOrNull { node -> offset in node.boundsInRoot }
      var data: DebugData? = null

      if (target != null && debugUi.value?.source?.raw != target) data = DebugViewOptions.resolver(target)

      if (data != null) {
        debugUi.value = calculateUi(bounds = target!!.boundsInRoot, data = data)
      } else if (target == null) {
        debugUi.value = null
      }

      println("Dispatched touch event ${debugUi.value}")
    }

    return if (DebugViewOptions.enabled) true else super.dispatchTouchEvent(event)
  }

  @Suppress("NOTHING_TO_INLINE")
  private inline fun requireOwner() =
    checkNotNull(owner) { "DebugComposeView is not started. ('owner' is null)" }

  @Suppress("NOTHING_TO_INLINE")
  private inline fun Set<Any>.isRealChanged(): Boolean =
    debugNodes as StateObject !in this &&
      debugUi as StateObject !in this &&
      DebugViewOptions._enabled as StateObject !in this

  private fun collectDebugNodesOrClearIfDestroyed() {
    val owner = owner ?: return debugNodes.clear()
    owner.rootForTest.semanticsOwner
      .getAllSemanticsNodes(mergingEnabled = false)
      .fastForEach { node ->
        if (!node.isRoot && !node.isInDebugView()) debugNodes[node.id] = node
      }
  }

  private fun SemanticsNode.isInDebugView(): Boolean {
    var current: SemanticsNode? = this
    do {
      if (current!!.config.contains(DebugViewOptions.Semantics)) {
        return true
      } else {
        current = current.parent
      }
    } while (current != null)
    return false
  }

  private companion object {
    const val DEFAULT_CACHE_SIZE = 15
    val DEFAULT_BACKGROUND_COLOR = Color.Gray.copy(alpha = 0.7f)

    val DEBUG_VIEW_PADDING = 8.dp
    val DEBUG_VIEW_SPACING = 4.dp

    val DEBUG_TITLE_STYLE = TextStyle(fontWeight = FontWeight.Bold)
    val DEBUG_CONTENT_STYLE = TextStyle.Default
  }
}

fun ComponentActivity.setDebugContent(
  parent: CompositionContext? = null,
  content: @Composable () -> Unit,
) {
  val existingDebugView = window.decorView
    .findViewById<ViewGroup>(android.R.id.content)
    .getChildAt(0) as? DebugComposeView

  if (existingDebugView != null) {
    with(existingDebugView) {
      setParentCompositionContext(parent)
      setContent(content)
    }
  } else {
    DebugComposeView(this).apply {
      setParentCompositionContext(parent)
      setContent(content)
      setOwners()
      setContentView(this, DefaultActivityContentLayoutParams)
    }
  }
}

// DebugView needs to be able to drag and drop freely, so we use MATCH_PARENT.
private val DefaultActivityContentLayoutParams =
  ViewGroup.LayoutParams(
    /* width = */ ViewGroup.LayoutParams.MATCH_PARENT,
    /* height = */ ViewGroup.LayoutParams.MATCH_PARENT,
  )

private fun ComponentActivity.setOwners() {
  val decorView = window.decorView
  if (decorView.findViewTreeLifecycleOwner() == null) {
    decorView.setViewTreeLifecycleOwner(this)
  }
  if (decorView.findViewTreeViewModelStoreOwner() == null) {
    decorView.setViewTreeViewModelStoreOwner(this)
  }
  if (decorView.findViewTreeSavedStateRegistryOwner() == null) {
    decorView.setViewTreeSavedStateRegistryOwner(this)
  }
}
