package land.sungbin.androidplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.WorkerThread
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import kotlin.reflect.KProperty

class PlaygroundActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      Main()
    }
  }
}

@Composable fun Main() {
  val aaa by Unit
  aaa
}

@Composable @WorkerThread @Deprecated("")
operator fun Unit.getValue(thisRef: Any?, property: KProperty<*>) {
  BasicText(property.name)
}
