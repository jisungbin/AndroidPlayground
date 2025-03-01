@file:OptIn(ExperimentalComposeUiApi::class)

package land.sungbin.androidplayground

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.CompositionLocal
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier

class PlaygroundActivity : ComponentActivity() {
  private val clazz = Class.forName("androidx.compose.ui.platform.AndroidCompositionLocals_androidKt")
  private val getLocalContext = clazz.getMethod("getLocalContext")

  @Suppress("UNCHECKED_CAST", "CompositionLocalNaming")
  private val result = getLocalContext.invoke(null) as CompositionLocal<Context>

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
      ) {
        Text(result.current.toString())
      }
    }
  }
}
