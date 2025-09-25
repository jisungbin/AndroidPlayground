package land.sungbin.androidplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
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
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
      ) {
        LazyRow(
          modifier = Modifier
            .width(150.dp)
            .border(width = 1.dp, color = Color.Black),
          contentPadding = PaddingValues(horizontal = 30.dp),
          horizontalArrangement = Arrangement.spacedBy(10.dp),
        ) {
          items(count = 2) {
            Box(
              Modifier
                .size(80.dp)
                .background(color = Color.Red),
            )
          }
        }
        Spacer(Modifier.height(100.dp))
        LazyRow(
          modifier = Modifier
            .width(150.dp)
            .border(width = 1.dp, color = Color.Black)
            .padding(horizontal = 30.dp),
          horizontalArrangement = Arrangement.spacedBy(10.dp),
        ) {
          items(count = 2) {
            Box(
              Modifier
                .size(80.dp)
                .background(color = Color.Blue),
            )
          }
        }
      }
    }
  }
}
