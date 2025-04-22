@file:OptIn(ExperimentalComposeUiApi::class, ExperimentalAnimatableApi::class, InternalComposeApi::class)

package land.sungbin.androidplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.ExperimentalAnimatableApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.InternalComposeApi
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@JvmInline
value class ComposableClass(
  val composable: @Composable (Modifier) -> Unit,
) : @Composable (Modifier) -> Unit by composable

class PlaygroundActivity : ComponentActivity() {
  private val test = ComposableClass { Text("TTTT", it) }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      test(
        Modifier
          .fillMaxSize()
          .wrapContentSize()
          .background(Color.Cyan)
      )
    }
  }
}
