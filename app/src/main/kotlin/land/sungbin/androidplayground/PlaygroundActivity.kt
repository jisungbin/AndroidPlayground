package land.sungbin.androidplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.currentRecomposeScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlin.random.Random

class PlaygroundActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      Text("recomposeScope-- is $currentRecomposeScope")
      Column {
        Spacer(modifier = Modifier.statusBarsPadding())
        Spacer(modifier = Modifier.height(4.dp))
        Text("recomposeScope00 is $currentRecomposeScope")
        a()
      }
    }
  }
}

object AA {
  @Composable
  fun A(): Int {
    val rc = currentRecomposeScope
    Text("recomposeScope22 is $rc", modifier = Modifier.clickable { rc.invalidate() })
    Text(System.currentTimeMillis().toString())
    return 1
  }
}

@Composable
fun a() {
  Text("recomposeScope11 is $currentRecomposeScope")
  Text(System.currentTimeMillis().toString())
  AA.A()
}
