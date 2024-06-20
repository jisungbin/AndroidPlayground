package land.sungbin.androidplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

class PlaygroundActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      Row(
        modifier = Modifier
          .fillMaxWidth()
          .height(300.dp)
          .border(width = 1.dp, color = Color.Black)
          .padding(horizontal = 30.dp),
      ) {
        Box(
          Modifier
            .padding(top = 50.dp)
            .size(size = 50.dp)
            .background(color = Color.Cyan),
        )
        Box(
          Modifier
            .padding(top = 150.dp, start = 30.dp)
            .size(size = 150.dp)
            .background(color = Color.Blue),
        )
      }
    }
  }
}
