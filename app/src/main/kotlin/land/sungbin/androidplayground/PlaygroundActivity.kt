package land.sungbin.androidplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

class PlaygroundActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      Box(
        modifier = Modifier
          .fillMaxWidth()
          .height(300.dp)
          .verticalScroll(rememberScrollState()),
      ) {
        Box(
          Modifier
            .fillMaxWidth()
            .height(600.dp)
            .background(brush = Brush.linearGradient(listOf(Color(0xFF00FF00), Color(0xFF0000FF))))
            .drawWithContent {
              drawContent()
              drawRect(
                color = Color.Cyan,
                size = Size(width = size.width, height = 50.dp.toPx()),
                topLeft = Offset(x = 0f, y = 550.dp.toPx()),
              )
            },
        )
      }
    }
  }
}
