@file:OptIn(ExperimentalComposeUiApi::class)

package land.sungbin.androidplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.layout.layout
import androidx.compose.ui.unit.dp

class PlaygroundActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      Column(Modifier.wrapContentSize()) {
        Box(
          Modifier
            .size(200.dp)
            .layout { measurable, constraints ->
              println("$constraints")
              val placeable = measurable.measure(constraints)
              layout(placeable.width, placeable.height) {
                placeable.place(0, 0)
              }
            }
            .drawBehind { println("$size") },
        )
      }
    }
  }
}
