package land.sungbin.androidplayground.app02

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

class ThirdActivity2 : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      Box(
        Modifier
          .fillMaxSize()
          .background(color = Color.Yellow)
          .clickable(onClick = ::finish),
      )
    }
  }

  @Suppress("OVERRIDE_DEPRECATION")
  override fun onBackPressed() {
    @Suppress("DEPRECATION")
    super.onBackPressed()
    finishAffinity()
  }
}
