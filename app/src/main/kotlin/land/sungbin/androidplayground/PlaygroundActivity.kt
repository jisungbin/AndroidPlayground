package land.sungbin.androidplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

class PlaygroundActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    enableEdgeToEdge()
    super.onCreate(savedInstanceState)
    setContent {
      Column(
        modifier = Modifier
          .fillMaxWidth()
          .height(300.dp)
          .background(color = Color.LightGray),
      ) {
        Box(
          Modifier
            .size(50.dp)
            .background(Color.Red)
            .align(Alignment.Start),
        )
        Box(
          Modifier
            .size(50.dp)
            .background(Color.Red)
            .align(Alignment.CenterHorizontally),
        )
        Box(
          Modifier
            .size(50.dp)
            .background(Color.Red)
            .align(Alignment.End),
        )
      }
    }
  }
}
