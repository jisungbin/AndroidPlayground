package land.sungbin.androidplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.onPlaced
import androidx.compose.ui.platform.ViewRootForTest
import androidx.compose.ui.semantics.SemanticsActions
import androidx.compose.ui.semantics.getAllSemanticsNodes
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.fastFirstOrNull
import androidx.compose.ui.util.fastForEach
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.android.awaitFrame
import kotlinx.coroutines.launch

@Suppress("VisibleForTests")
class PlaygroundActivity : ComponentActivity() {
  private lateinit var root: ViewRootForTest
  private val debugBounds = mutableStateMapOf<Int, Rect>()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    ViewRootForTest.onViewCreatedCallback = { root -> this.root = root }
    setContent {
      Box(
        modifier = Modifier
          .fillMaxSize()
          .drawWithContent {
            drawContent()
            debugBounds.values.forEach { bounds ->
              drawRect(
                color = Color.Red,
                topLeft = bounds.topLeft,
                size = bounds.size,
                style = Stroke(width = 1.dp.toPx()),
              )
            }
          },
        contentAlignment = Alignment.Center,
      ) {
        Text(
          modifier = Modifier.onPlaced {
            val allNodes = root.semanticsOwner.getAllSemanticsNodes(mergingEnabled = false, skipDeactivatedNodes = false)

            print("Found semantics: ")
            println(allNodes.joinToString { node -> node.config.joinToString { it.key.name } })

            val textNode = allNodes.fastFirstOrNull { node -> node.config.contains(SemanticsActions.GetTextLayoutResult) } ?: return@onPlaced
            val textLayouts = ArrayList<TextLayoutResult>().apply {
              val result = textNode.config[SemanticsActions.GetTextLayoutResult].action!!.invoke(this)
              if (!result) return@onPlaced println("Failed to get text layout result!")
            }

            textLayouts.first().layoutInput.let { layout ->
              println("Found text layout for text \"${layout.text}\":")
              println("- style: ${layout.style}")
              println("- constraints: ${layout.constraints}")
              println("- density: ${layout.density.density}")
            }
          },
          text = "Hello my text!",
        )
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
          .fastForEach { node -> debugBounds[node.id] = node.boundsInRoot }
      }
    }
  }
}
