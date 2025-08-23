package land.sungbin.androidplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import kotlin.reflect.KProperty

class PlaygroundActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      val aaa by Unit
      aaa
    }
  }
}

@Composable
operator fun Unit.getValue(thisRef: Any?, property: KProperty<*>) {
  BasicText(property.name)
}
