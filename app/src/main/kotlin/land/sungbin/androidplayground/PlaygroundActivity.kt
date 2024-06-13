// TODO remove file-level suppression (KT-30155, KT-18603)
@file:Suppress("INVISIBLE_REFERENCE", "INVISIBLE_MEMBER")

package land.sungbin.androidplayground

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.collection.MutableIntObjectMap
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Stable
import androidx.compose.runtime.currentRecomposeScope
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.geometry.center
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.input.pointer.PointerEvent
import androidx.compose.ui.input.pointer.PointerEventPass
import androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNode
import androidx.compose.ui.layout.onPlaced
import androidx.compose.ui.node.DelegatingNode
import androidx.compose.ui.node.LayoutAwareModifierNode
import androidx.compose.ui.node.ModifierNodeElement
import androidx.compose.ui.node.PointerInputModifierNode
import androidx.compose.ui.node.Ref
import androidx.compose.ui.node.SemanticsModifierNode
import androidx.compose.ui.node.invalidateSemantics
import androidx.compose.ui.node.requireDensity
import androidx.compose.ui.node.requireLayoutNode
import androidx.compose.ui.platform.InspectorInfo
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.semantics.SemanticsPropertyKey
import androidx.compose.ui.semantics.SemanticsPropertyReceiver
import androidx.compose.ui.semantics.getAllSemanticsNodes
import androidx.compose.ui.semantics.getOrNull
import androidx.compose.ui.semantics.onClick
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize
import org.jetbrains.annotations.TestOnly
import java.util.concurrent.atomic.AtomicInteger

class PlaygroundActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      val owner = LocalView.current as androidx.compose.ui.node.Owner
      val recomposeScope = currentRecomposeScope

      val bounds = remember { mutableStateListOf<Rect>() }

      Box(
        Modifier
          .fillMaxSize()
          .drawBehind {
            val clickableArea = Rect(
              offset = size.center,
              size = Size(width = 50.dp.toPx(), height = 50.dp.toPx()),
            )

            drawRect(
              color = Color.Blue,
              topLeft = clickableArea.topLeft,
              size = clickableArea.size,
              alpha = 0.8f,
            )

            bounds.forEach { clickableBound ->
              drawRect(
                color = Color.Red,
                topLeft = clickableBound.topLeft,
                size = clickableBound.size,
                style = Stroke(width = 1.dp.toPx()),
              )
            }
          }
          .clickableBoundingRect(
            semanticsEnabled = true,
            rect = { size ->
              Rect(
                offset = size.center,
                size = Size(width = 50.dp.toPx(), height = 50.dp.toPx()),
              )
            },
            onClick = { offset ->
              Toast
                .makeText(applicationContext, "$offset was clicked.", Toast.LENGTH_SHORT)
                .show()
              recomposeScope.invalidate()
            },
          )
          .onPlaced {
            val semantics = owner.rootForTest.semanticsOwner.getAllSemanticsNodes(mergingEnabled = false)
            val boundingNode = semantics.first { node -> node.config.contains(PointerInputBounds) }

            boundingNode.config[PointerInputBounds].forEachValue(bounds::add)
          },
      )
    }
  }
}

@Stable
fun Modifier.clickableBoundingRect(
  vararg keys: Any?,
  semanticsEnabled: Boolean,
  rect: Density.(size: Size) -> Rect,
  onClick: (offset: Offset) -> Unit,
): Modifier = this then SuspendBoundingPointerInputElement(
  keys = keys,
  rect = rect,
  onClick = onClick,
  semanticsEnabled = semanticsEnabled,
)

private val PointerInputBounds = SemanticsPropertyKey<MutableIntObjectMap<Rect>>("PointerInputBounds")

private class SuspendBoundingPointerInputElement(
  val key1: Any? = null,
  val key2: Any? = null,
  val keys: Array<out Any?>? = null,
  val rect: Density.(size: Size) -> Rect,
  val onClick: (offset: Offset) -> Unit,
  val semanticsEnabled: Boolean,
) : ModifierNodeElement<SuspendBoundingPointerInputNode>() {
  // TODO should be WeakReference?
  private var instance: SuspendBoundingPointerInputNode? = null

  override fun create(): SuspendBoundingPointerInputNode =
    SuspendBoundingPointerInputNode(
      rect = rect,
      onClick = onClick,
      semanticsEnabled = semanticsEnabled,
    ).also { node ->
      instance = node
    }

  override fun update(node: SuspendBoundingPointerInputNode) {
    node.rect = rect
    node.onClick = onClick
    node.semanticsEnabled = semanticsEnabled
    node.updateBounds()
    instance = node // Ensure the instance is up to date
  }

  override fun InspectorInfo.inspectableProperties() {
    val instance = instance
    name = "clickableBoundingRect"
    if (instance == null) {
      value = "Not yet created"
    } else {
      properties["rect"] = instance.currentRect()
      properties["onClick"] = onClick
      properties["semanticsEnabled"] = semanticsEnabled
    }
  }

  override fun equals(other: Any?): Boolean {
    if (this === other) return true
    if (other !is SuspendBoundingPointerInputElement) return false

    if (key1 != other.key1) return false
    if (key2 != other.key2) return false
    if (keys != null) {
      if (other.keys == null) return false
      if (!keys.contentEquals(other.keys)) return false
    } else if (other.keys != null) return false

    return true
  }

  override fun hashCode(): Int {
    var result = key1.hashCode()
    result = 31 * result + key2.hashCode()
    result = 31 * result + keys.contentHashCode()
    return result
  }
}

// --- SuspendBoundingPointerInputNode design notes ---

// PointerInputScope is executed as a lazy calculation. But we need fast execution
// for immediate semantic updates. So we don't use the PointerInputScope, we calculate
// the Rect on the fly with Density and Size.

// While applySemantics ensures snapshot observation with snapshotObserver, other
// areas that use bounds and lastSize do not use snapshotObserver, so we use Ref
// rather than State for consistency.

private val elementIdCounter = AtomicInteger(0)

// TODO this field should be provided as a ModifierLocal, but the SuspendBoundingPointerInputNode
//  can be applied multiple times, so a separate ModifierLocalProviderNode should be created,
//  but this creates a boilerplate that requires a ModifierLocalProviderNode to be attached each
//  time. I can't think of a good way to do that right now, so we'll use this approach.
private val dirtyElementIds = mutableSetOf<Int>()

private class SuspendBoundingPointerInputNode(
  var rect: Density.(size: Size) -> Rect,
  var onClick: (offset: Offset) -> Unit,
  var semanticsEnabled: Boolean,
) : DelegatingNode(), PointerInputModifierNode, SemanticsModifierNode, LayoutAwareModifierNode {
  private val lastSize = Ref<Size>()
  private val bounds = Ref<Rect>()

  private var previousSemantics: MutableIntObjectMap<Rect>? = null
  private val elementId = elementIdCounter.getAndIncrement()

  private val pointerInputDelegate = delegate(
    SuspendingPointerInputModifierNode {
      detectTapGestures { offset ->
        val bounds = checkNotNull(bounds.value) {
          "A click event was requested before the click area was calculated."
        }
        if (offset in bounds) onClick(offset)
      }
    },
  )

  @Suppress("INVISIBLE_MEMBER")
  fun updateBounds() {
    val size = checkNotNull(lastSize.value) {
      "A click area calculation was requested before the composable was placed."
    }
    bounds.value = rect(requireDensity(), size)

    if (semanticsEnabled) {
      previousSemantics = requireLayoutNode().collapsedSemantics?.getOrNull(PointerInputBounds)
      invalidateSemantics()
    }
  }

  @TestOnly
  fun currentRect(): Rect? = bounds.value

  // It also runs on the initial measure.
  override fun onRemeasured(size: IntSize) {
    lastSize.value = size.toSize()
    println("onRemeasured is $size")
    updateBounds()
  }

  override fun onPointerEvent(
    pointerEvent: PointerEvent,
    pass: PointerEventPass,
    bounds: IntSize,
  ) {
    pointerInputDelegate.onPointerEvent(
      pointerEvent = pointerEvent,
      pass = pass,
      bounds = bounds,
    )
  }

  override fun SemanticsPropertyReceiver.applySemantics() {
    // TODO support for offset-specific click actions
    onClick(label = "clickableBoundingRect") {
      this@SuspendBoundingPointerInputNode.onClick.invoke(Offset.Zero)
      true
    }

    if (!semanticsEnabled) return

    val value = bounds.value ?: return
    val new = run {
      val previous = previousSemantics
      if (previous != null) {
        dirtyElementIds.removeIf { dirty -> previous.remove(dirty) != null }
        previous
      } else {
        MutableIntObjectMap()
      }
    }

    this[PointerInputBounds] = new.apply { put(elementId, value) }
  }

  override fun onViewConfigurationChange() {
    pointerInputDelegate.onViewConfigurationChange()
    updateBounds()
  }

  override fun onDensityChange() {
    pointerInputDelegate.onDensityChange()
    updateBounds()
  }

  override fun onCancelPointerInput() {
    pointerInputDelegate.onCancelPointerInput()
  }

  override fun interceptOutOfBoundsChildEvents(): Boolean =
    pointerInputDelegate.interceptOutOfBoundsChildEvents()

  override fun sharePointerInputWithSiblings(): Boolean =
    pointerInputDelegate.sharePointerInputWithSiblings()

  override fun onDetach() {
    if (!semanticsEnabled) return

    dirtyElementIds += elementId
    invalidateSemantics()
  }
}

