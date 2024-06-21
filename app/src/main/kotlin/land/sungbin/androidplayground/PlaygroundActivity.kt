package land.sungbin.androidplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.drawText
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.unit.dp

class PlaygroundActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      val textMeasurer = rememberTextMeasurer(cacheSize = 1)
      val textLayout = textMeasurer.measure("Hello, World")
      Box(
        Modifier
          .fillMaxSize()
          .drawBehind {
            drawText(textLayoutResult = textLayout)
            drawRect(
              color = Color.Red,
              topLeft = Offset(
                x = textLayout.getLineRight(0),
                y = textLayout.size.height + 5.dp.toPx(),
              ),
              size = Size(width = 5.dp.toPx(), height = 1.dp.toPx()),
            )
          },
      )
    }
  }
}
