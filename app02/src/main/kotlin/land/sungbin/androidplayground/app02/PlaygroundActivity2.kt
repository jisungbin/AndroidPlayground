@file:Suppress("KDocUnresolvedReference", "SpellCheckingInspection")

package land.sungbin.androidplayground.app02

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

class PlaygroundActivity2 : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      Box(
        Modifier
          .fillMaxSize()
          .background(color = Color.Cyan)
          .clickable {
            val intent = Intent(this, SecondActivity2::class.java).apply {
              putExtra("test", System.currentTimeMillis().toString())
            }
            startActivity(intent)
          },
      )
    }
  }
}
