package land.sungbin.androidplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class PlaygroundActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      Row(
        Modifier
          .pointerInput(Unit) { println("pointer: $size") }
          .fillMaxHeight(),
      ) {
        // The center of the magenta Box and the baselines of the two texts will be
        // vertically aligned. Note that alignBy() or alignByBaseline() has to be specified
        // for all children we want to take part in the alignment. For example, alignByBaseline()
        // means that the baseline of the text should be aligned with the alignment line
        // (possibly another baseline) specified for siblings using alignBy or alignByBaseline.
        // If no other sibling had alignBy() or alignByBaseline(), the modifier would have no
        // effect.
        Box(
          modifier = Modifier
            .size(80.dp, 40.dp)
            .alignBy { it.measuredHeight / 2 }
            .background(Color.Magenta)
        )
        Text(
          text = "Text 1",
          fontSize = 40.sp,
          modifier = Modifier
            .alignByBaseline()
            .background(color = Color.Red)
        )
        Text(
          text = "Text 2",
          modifier = Modifier
            .alignByBaseline()
            .background(color = Color.Cyan)
        )
      }
    }
  }
}
