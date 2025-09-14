package land.sungbin.androidplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.currentRecomposeScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class PlaygroundActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      Column {
        Spacer(modifier = Modifier.statusBarsPadding())
        Spacer(modifier = Modifier.height(4.dp))

        val r = currentRecomposeScope
        Text("$r with ${System.currentTimeMillis()}", modifier = Modifier.clickable { r.invalidate() })

        Spacer(modifier = Modifier.height(4.dp))

        TestImpl.Content()

        Spacer(modifier = Modifier.height(4.dp))

        Test2.Content()
      }
    }
  }
}

fun interface Test {
  @Composable
  fun Content()
}

object TestImpl : Test {
  @Composable
  override fun Content() { // final
    val r = currentRecomposeScope
    Text("$r with ${System.currentTimeMillis()}", modifier = Modifier.clickable { r.invalidate() })
  }
}

open class Test2 : Test {
  @Composable
  override fun Content() { // open
    val r = currentRecomposeScope
    Text("$r with ${System.currentTimeMillis()}", modifier = Modifier.clickable { r.invalidate() })
  }

  companion object : Test2()
}



