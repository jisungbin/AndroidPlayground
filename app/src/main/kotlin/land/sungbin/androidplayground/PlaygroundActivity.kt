package land.sungbin.androidplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DontMemoize

class PlaygroundActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent @DontMemoize {
      A()
    }
  }
}

@Composable
fun Test(a: Any = 1) {
}

@Composable
fun A() {
  Test()
}
