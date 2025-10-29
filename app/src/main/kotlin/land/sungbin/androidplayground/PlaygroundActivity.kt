package land.sungbin.androidplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

class PlaygroundActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    enableEdgeToEdge()
    super.onCreate(savedInstanceState)
    setContent {
      Box(
        modifier = Modifier
          .statusBarsPadding()
          .width(100.dp)
          .horizontalScroll(rememberScrollState())
          .padding(start = 50.dp)
          .border(0.5.dp, Color.Black)
      ) {
        Row {
          Text(
            "1",
            modifier = Modifier
              .width(300.dp)
              .border(1.dp, Color.Blue)
          )
          Text(
            "2",
            modifier = Modifier
              .width(100.dp)
              .border(1.dp, Color.Green)
          )
        }
      }
    }
  }
}
