package land.sungbin.androidplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

class PlaygroundActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      Column(modifier = Modifier.fillMaxSize()) {
        LazyColumn(
          modifier = Modifier
            .fillMaxSize()
            .drawWithContent {
              drawContent()

              val drawingHeight = 15.dp.roundToPx()
              val alphaPerLine = 1f / drawingHeight

              repeat(drawingHeight) { linePx ->
                drawLine(
                  color = Color.White.copy(alpha = 1f - alphaPerLine * linePx),
                  start = Offset(x = 0f, y = linePx.toFloat()),
                  end = Offset(x = size.width, y = linePx.toFloat()),
                )
              }
            },
        ) {
          items(count = 500) {
            Text(text = "Hello, $it!")
          }
        }
      }
    }
  }
}
