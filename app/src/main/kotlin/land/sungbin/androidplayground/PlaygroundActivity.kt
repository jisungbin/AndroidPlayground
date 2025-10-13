package land.sungbin.androidplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

class PlaygroundActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    enableEdgeToEdge()
    super.onCreate(savedInstanceState)
    setContent {
      Box(
        modifier =
          Modifier
            .fillMaxSize()
            .wrapContentSize()
            .size(100.dp)
            .horizontalScroll(rememberScrollState())
            .verticalScroll(rememberScrollState())
            .border(1.dp, Color.Black),
      ) {
        Box(
          Modifier
            .size(250.dp)
            .background(
              brush = Brush.horizontalGradient(
                colors = listOf(
                  Color.Red,
                  Color.Yellow,
                  Color.Green,
                  Color.Cyan,
                  Color.Blue,
                  Color.Magenta,
                  Color.Red,
                )
              )
            ),
        )
      }
    }
  }
}
