package land.sungbin.androidplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onPlaced
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.platform.ViewRootForTest
import androidx.compose.ui.semantics.SemanticsActions
import androidx.compose.ui.semantics.getAllSemanticsNodes
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.util.fastFirstOrNull
import androidx.compose.ui.util.fastForEach

@Suppress("VisibleForTests")
class PlaygroundActivity : ComponentActivity() {
  private lateinit var root: ViewRootForTest

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    ViewRootForTest.onViewCreatedCallback = { root ->
      this.root = root
//      val textNode = allNodes.firstOrNull { node -> node.config.contains(SemanticsProperties.Text) }
//
//      print("Found text nodes: ")
//      println(textNode.config[SemanticsProperties.Text].joinToString())
    }
    setContent {
      val view = LocalView.current

      Box(
        modifier = Modifier.fillMaxSize(),
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

            println("Found text layout for text \"${textLayouts.first().layoutInput.text}\":")
            textLayouts.fastForEach { layout ->
              println("- style: ${layout.layoutInput.style}")
              println("- constraints: ${layout.layoutInput.constraints}")
              println("- density: ${layout.layoutInput.density.density}")
            }
          },
          text = "Hello my text!",
        )
      }
    }
  }
}