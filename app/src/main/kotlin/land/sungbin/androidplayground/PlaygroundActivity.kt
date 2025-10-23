package land.sungbin.androidplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
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
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
      ) {
        FirstBox()
      }
    }
  }
}

@Composable fun FirstBox() {
  Box(
    Modifier
      .size(300.dp)
      .background(Color.Gray),
    contentAlignment = Alignment.Center,
  ) {
    SecondBox()
  }
}


@Composable fun SecondBox() {
  Box(
    Modifier
      .size(200.dp)
      .background(Color.Blue),
    contentAlignment = Alignment.Center,
  ) {
    ThirdBox()
  }
}

@Composable fun ThirdBox() {
  Box(
    Modifier
      .size(100.dp)
      .background(Color.Green),
  )
}
