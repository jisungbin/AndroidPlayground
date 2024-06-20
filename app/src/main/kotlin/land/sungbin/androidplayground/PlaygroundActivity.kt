package land.sungbin.androidplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

class PlaygroundActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      var expanded by remember { mutableStateOf(false) }

      Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomStart,
      ) {
        Column(
          modifier = Modifier
            .fillMaxWidth()
            .then(
              if (!expanded) Modifier.height(100.dp)
              else Modifier
                .fillMaxHeight(fraction = 0.5f)
                .wrapContentHeight(align = Alignment.Bottom),
            )
            .clickable { expanded = !expanded }
            .background(color = Color.Cyan),
        ) {
          Text("Text")
          Box(Modifier.weight(1f, fill = true))
        }
      }
    }
  }
}