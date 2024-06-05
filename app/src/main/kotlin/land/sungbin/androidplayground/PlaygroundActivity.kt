package land.sungbin.androidplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.ViewRootForTest
import androidx.compose.ui.semantics.SemanticsNode
import androidx.compose.ui.semantics.SemanticsProperties
import androidx.compose.ui.semantics.SemanticsPropertyKey
import androidx.compose.ui.semantics.getAllSemanticsNodes
import androidx.compose.ui.semantics.getOrNull
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.IntRect
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.roundToIntRect
import androidx.compose.ui.unit.toSize
import androidx.compose.ui.util.fastForEach
import androidx.compose.ui.window.Popup
import androidx.compose.ui.window.PopupPositionProvider
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.android.awaitFrame
import kotlinx.coroutines.launch

@Suppress("VisibleForTests")
class PlaygroundActivity : ComponentActivity() {
  private lateinit var root: ViewRootForTest

  private val debugNodes = mutableStateMapOf<Int, SemanticsNode>()
  private var debugData by mutableStateOf<Pair<Rect, List<String>>?>(null)

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    ViewRootForTest.onViewCreatedCallback = { root -> this.root = root }
    setContent {
      val debugData = debugData
      if (debugData != null) {
        Popup(
          // PopupPositionProvider: Why not functional interface?
          popupPositionProvider = object : PopupPositionProvider {
            override fun calculatePosition(
              anchorBounds: IntRect,
              windowSize: IntSize,
              layoutDirection: LayoutDirection,
              popupContentSize: IntSize,
            ): IntOffset {
              var candidateX: Int
              var candidateY: Int

              @Suppress("NAME_SHADOWING")
              val anchorBounds = debugData.first.roundToIntRect()

              candidateX = (anchorBounds.left - popupContentSize.width / 2).coerceAtLeast(0)
              if (candidateX + popupContentSize.width > windowSize.width) {
                candidateX = (windowSize.width - popupContentSize.width).coerceAtLeast(0)
              }

              candidateY = (anchorBounds.top - popupContentSize.height).coerceAtLeast(0)
              if (candidateY + popupContentSize.height > windowSize.height) {
                candidateY = (windowSize.height - popupContentSize.height).coerceAtLeast(0)
              }

              return IntOffset(x = candidateX, y = candidateY)
            }
          },
          onDismissRequest = { this.debugData = null },
        ) {
          Column(
            modifier = Modifier
              .wrapContentSize()
              .background(color = Color.Gray.copy(alpha = 0.8f))
              .padding(all = 30.dp),
            verticalArrangement = Arrangement.spacedBy(space = 4.dp),
          ) {
            debugData.second.forEach { debug -> Text(text = "- $debug") }
          }
        }
      }

      Box(
        modifier = Modifier
          .fillMaxSize()
          .pointerInput(debugNodes.hashCode()) {
            detectTapGestures { offset ->
              val target = debugNodes.values.firstOrNull { node -> offset in node.boundsInRoot }
              if (target != null) {
                val debug = listOf(
                  "id: ${target.id}",
                  "boundsInRoot: ${target.boundsInRoot}",
                  "boundsInWindow: ${target.boundsInWindow}",
                  "size: ${target.size}",
                  "text: ${target.config.getOrNull(SemanticsProperties.Text)?.firstOrNull()}",
                )
                this@PlaygroundActivity.debugData = target.boundsInRoot to debug
              } else {
                this@PlaygroundActivity.debugData = null
              }
            }
          }
          .drawWithContent {
            drawContent()
            debugNodes.values.forEach { node ->
              drawRect(
                color = Color.Red,
                topLeft = node.boundsInRoot.topLeft,
                size = node.size.toSize(),
                style = Stroke(width = 1.dp.toPx()),
              )
            }
          },
        contentAlignment = Alignment.Center,
      ) {
        Text(text = "Hello my text!")
      }
    }
  }

  override fun onAttachedToWindow() {
    lifecycleScope.launch {
      while (true) {
        awaitFrame()
        if (!::root.isInitialized) {
          println("'root' is not initialized!")
          continue
        }
        root.semanticsOwner
          .getAllSemanticsNodes(mergingEnabled = false, skipDeactivatedNodes = false)
          .fastForEach { node -> debugNodes[node.id] = node }
      }
    }
  }
}
