package land.sungbin.androidplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

class PlaygroundActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    enableEdgeToEdge()
    super.onCreate(savedInstanceState)
    setContent {
      Box(
        Modifier
          .fillMaxSize()
          .background(Color(0xFFF5F5F5))
          .wrapContentSize()
          .border(width = 2.dp, color = Color.Black)
          .padding(all = 50.dp)
          .size(300.dp)
//          .border(width = 2.dp, color = Color.Black)
          .background(Color.Gray),
        contentAlignment = Alignment.Center,
      ) {
        Box(
          Modifier
            .size(200.dp)
//            .border(width = 2.dp, color = Color.Black)
            .background(Color(0xFF5F5FFF)),
          contentAlignment = Alignment.Center,
        ) {
          Box(
            Modifier
              .size(100.dp)
//              .border(width = 2.dp, color = Color.Black)
              .background(Color(0xFF00B700)),
          )
        }
      }
    }
  }
}
