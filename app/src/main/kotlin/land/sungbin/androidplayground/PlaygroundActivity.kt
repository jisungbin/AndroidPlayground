@file:Suppress("VisibleForTests")

package land.sungbin.androidplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.ObserverHandle
import androidx.compose.runtime.snapshots.Snapshot
import androidx.compose.runtime.snapshots.StateObject
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.layout
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.platform.ViewRootForTest
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.semantics.SemanticsNode
import androidx.compose.ui.semantics.SemanticsProperties
import androidx.compose.ui.semantics.getAllSemanticsNodes
import androidx.compose.ui.semantics.getOrNull
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.round
import androidx.compose.ui.unit.roundToIntRect
import androidx.compose.ui.unit.toSize
import androidx.compose.ui.util.fastForEach
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.android.awaitFrame
import kotlinx.coroutines.awaitCancellation
import kotlinx.coroutines.launch
import java.util.UUID
import kotlin.concurrent.thread

private val DEBUG_POPUP_ID = UUID.randomUUID().toString()

class PlaygroundActivity : ComponentActivity() {
  private lateinit var root: ViewRootForTest

  private val debugNodes = mutableStateMapOf<Int, SemanticsNode>()
  private val debugData = mutableStateOf<Pair<Rect, List<String>>?>(null)
  private val debugPopupDraggedOffset = mutableStateOf(Offset.Zero)

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      if (!::root.isInitialized) root = LocalView.current as ViewRootForTest

      Box(
        modifier = Modifier
          .fillMaxSize()
          .pointerInput(debugNodes.values) {
            detectTapGestures { offset ->
              val target = debugNodes.values.firstOrNull { node -> offset in node.boundsInRoot }
              if (target != null) {
                val debug = listOf(
                  "id: ${target.id}",
                  "size: ${target.size}",
                  "position: ${target.positionInRoot}",
                )
                debugData.value = target.boundsInRoot to debug
              } else {
                debugData.value = null
              }
            }
          }
          .pointerInput(debugPopupDraggedOffset) {
            detectDragGestures { _, dragAmount ->
              debugPopupDraggedOffset.value += dragAmount
            }
          }
          .drawWithContent {
            drawContent()
            debugNodes.values.forEach { node ->
              drawRect(
                color = Color.Red,
                topLeft = node.positionInRoot,
                size = node.size.toSize(),
                style = Stroke(width = 1.dp.toPx()),
              )
            }
          },
      ) {
        Text("Hello my text!", modifier = Modifier.align(Alignment.Center))

        @Suppress("LocalVariableName")
        debugData.value?.let { _debugData ->
          Column(
            modifier = Modifier
              .testTag(DEBUG_POPUP_ID)
              .fillMaxSize()
              .layout { measurable, constraints ->
                val looseConstraints = constraints.copy(minWidth = 0, minHeight = 0)
                val placeable = measurable.measure(looseConstraints)

                val position = DebugPopupPositionProvider.calculatePosition(
                  anchorBounds = _debugData.first.roundToIntRect(),
                  windowSize = IntSize(width = constraints.maxWidth, height = constraints.maxHeight),
                  layoutDirection = layoutDirection,
                  popupContentSize = IntSize(width = placeable.width, height = placeable.height),
                )

                layout(width = constraints.maxWidth, height = constraints.maxHeight) {
                  placeable.place(position = position + debugPopupDraggedOffset.value.round())
                }
              }
              .heightIn(max = 150.dp)
              .background(color = Color.Gray.copy(alpha = 0.8f))
              .padding(all = 8.dp),
            verticalArrangement = Arrangement.spacedBy(space = 4.dp),
          ) {
            Text("[#ComposableId] - TestId", style = LocalTextStyle.current.copy(fontWeight = FontWeight.Bold))
            _debugData.second.fastForEach { debug -> Text("- $debug") }

            DisposableEffect(debugPopupDraggedOffset) {
              onDispose {
                debugPopupDraggedOffset.value = Offset.Zero
              }
            }
          }
        }
      }
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
        lifecycleScope.launch {
          while (true) {
            awaitFrame()
            if (!::root.isInitialized) {
              println("'root' is not initialized yet!")
              continue
            }

            collectDebugNodes()
            println("Collected ${debugNodes.size} debug nodes")
            break
          }

          debugNodeCollectorDisposeHandle = Snapshot.registerApplyObserver { changes, _ ->
            if (!changes.isRealChanged()) return@registerApplyObserver
            collectDebugNodes()
            println("Re-collected ${debugNodes.size} debug nodes")
          }

          awaitCancellation()
        }
      } finally {
        debugNodeCollectorDisposeHandle?.dispose()
      }
    }
  }

  private fun Set<Any>.isRealChanged(): Boolean =
    debugNodes as StateObject !in this &&
      debugData as StateObject !in this &&
      debugPopupDraggedOffset as StateObject !in this

  private fun collectDebugNodes() {
    root.semanticsOwner
      .getAllSemanticsNodes(mergingEnabled = false)
      .fastForEach { node ->
        if (!node.isRoot && !node.isInDebugPopup()) debugNodes[node.id] = node
      }
  }

  private fun SemanticsNode.isInDebugPopup(): Boolean {
    var current: SemanticsNode? = this
    do {
      if (current!!.config.getOrNull(SemanticsProperties.TestTag) == DEBUG_POPUP_ID) {
        return true
      } else {
        current = current.parent
      }
    } while (current != null)
    return false
  }
}
