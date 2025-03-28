@file:OptIn(ExperimentalComposeUiApi::class, ExperimentalAnimatableApi::class, InternalComposeApi::class)

package land.sungbin.androidplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.ExperimentalAnimatableApi
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Composer
import androidx.compose.runtime.InternalComposeApi
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.currentComposer
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Density

class PlaygroundActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      val composer = currentComposer

      LaunchedEffect(composer) {
        println("CALL!!")
        println(
          invokeComposable<Painter>(composer) {
            currentComposer.startProvider(LocalDensity provides Density(this@PlaygroundActivity))
            rememberVectorPainter(Icons.Default.Favorite).also { currentComposer.endProvider() }
          }
        )
      }
    }
  }
}

// https://github.com/androidx/androidx/blob/f3ae39e92fbaf02f36011fbe6747aa2aa89da417/compose/runtime/runtime/src/jvmMain/kotlin/androidx/compose/runtime/internal/Expect.jvm.kt#L22
private fun <T> invokeComposable(composer: Composer, composable: @Composable () -> T): T {
  @Suppress("UNCHECKED_CAST") val realFn = composable as Function2<Composer, Int, T>
  return realFn(composer, 1)
}
