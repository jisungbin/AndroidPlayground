@file:Suppress("INVISIBLE_REFERENCE", "INVISIBLE_MEMBER")

package land.sungbin.androidplayground

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.ViewGroup
import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.Box
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.node.Owner
import androidx.compose.ui.platform.AbstractComposeView
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.semantics.SemanticsNode
import androidx.compose.ui.semantics.getAllSemanticsNodes
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize
import androidx.compose.ui.util.fastForEach
import androidx.lifecycle.findViewTreeLifecycleOwner
import androidx.lifecycle.findViewTreeViewModelStoreOwner
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.setViewTreeLifecycleOwner
import androidx.lifecycle.setViewTreeViewModelStoreOwner
import androidx.savedstate.findViewTreeSavedStateRegistryOwner
import androidx.savedstate.setViewTreeSavedStateRegistryOwner
import kotlinx.coroutines.android.awaitFrame
import kotlinx.coroutines.awaitCancellation
import kotlinx.coroutines.launch
import kotlin.concurrent.thread

@Suppress("VisibleForTests")
class DebugComposeView @JvmOverloads constructor(
  context: Context,
  attrs: AttributeSet? = null,
  defStyleAttr: Int = 0,
) : AbstractComposeView(context, attrs, defStyleAttr) {
  internal var owner: Owner? = null
  private var debugPopup: DebugPopupWindow? = DebugPopupWindow()

  private val debugNodes = mutableStateMapOf<Int, SemanticsNode>()
  internal val debugData = mutableStateOf<Pair<Rect, DebugData>?>(null)

  private val content = mutableStateOf<(@Composable () -> Unit)?>(null)

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

      Box(modifier = if (DebugViewOptions.enabled) layoutBoundsDrawingModifier() else Modifier) {
        content()
      }
      if (isAttachedToWindow) createComposition()
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

  override fun onAttachedToWindow() {
    var debugNodeCollectorDisposeHandle: ObserverHandle? = null
    thread(
      name = "DebugNodeCollector",
      isDaemon = true,
      priority = Thread.NORM_PRIORITY,
    ) {
      try {
        findViewTreeLifecycleOwner()!!.lifecycleScope.launch {
          while (true) {
            awaitFrame()
            // TODO "===" -> "=="
            if (owner === null) {
              println("'root' is not initialized yet!")
              continue
            }

            collectDebugNodesOrClearIfDestroyed()
            println("Collected ${debugNodes.size} debug nodes")
            break
          }

          debugNodeCollectorDisposeHandle = Snapshot.registerApplyObserver { changes, _ ->
            if (!changes.isRealChanged()) return@registerApplyObserver
            collectDebugNodesOrClearIfDestroyed()
            println("Re-collected ${debugNodes.size} debug nodes")
          }
          debugPopup?.start(host = this@DebugComposeView)

          awaitCancellation()
        }
      } finally {
        debugNodeCollectorDisposeHandle?.dispose()
        debugData.value = null
        debugNodes.clear()
        debugPopup = null
        owner = null
      }
    }
    super.onAttachedToWindow()
  }

  // TODO testing multi-window support
  override fun dispatchTouchEvent(ev: MotionEvent): Boolean {
    val offset = Offset(x = ev.x, y = ev.y)

    val target = debugNodes.values.firstOrNull { node -> offset in node.boundsInRoot }
    if (target != null) {
      debugData.value = target.boundsInRoot to DebugViewOptions.resolver(target)
    } else {
      debugData.value = null
    }

    return if (DebugViewOptions.enabled) true else super.dispatchTouchEvent(ev)
  }

  private fun Set<Any>.isRealChanged(): Boolean =
    debugNodes as StateObject !in this &&
      debugData as StateObject !in this &&
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
