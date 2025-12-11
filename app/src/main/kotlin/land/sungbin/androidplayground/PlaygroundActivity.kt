package land.sungbin.androidplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.dropShadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.shadow.Shadow
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp

class PlaygroundActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    enableEdgeToEdge()
    super.onCreate(savedInstanceState)
    setContent {
      Box(
        Modifier
          .fillMaxSize()
          .background(color = Color.White)
          .wrapContentSize()
          .size(80.dp)
          .dropShadow(
            shape = RoundedCornerShape(12.dp),
            shadow = Shadow(
              offset = DpOffset(0.dp, 6.dp),
              radius = 12.dp,
              spread = 3.dp,
              color = Color.Black.copy(alpha = 0.08f),
            )
          )
          .dropShadow(
            shape = RoundedCornerShape(12.dp),
            shadow = Shadow(
              offset = DpOffset(0.dp, 8.dp),
              radius = 16.dp,
              spread = 0.dp,
              color = Color.Black.copy(alpha = 0.2f),
            )
          )
          .background(color = Color.White, shape = RoundedCornerShape(12.dp)),
      )
    }
  }
}
