package land.sungbin.androidplayground

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.drawText
import androidx.compose.ui.text.rememberTextMeasurer

class SecondActivity : ComponentActivity() {
  private val ms by lazy { intent.getStringExtra("test")!! }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      val textMeasurer = rememberTextMeasurer()

      Box(
        Modifier
          .fillMaxSize()
          .background(color = Color.Blue)
          .drawBehind { drawText(textMeasurer = textMeasurer, text = ms) }
          .clickable { startActivity(Intent(this, ThirdActivity::class.java)) },
      )

      LaunchedEffect(Unit) {
        println("Enter with $textMeasurer")
      }
    }
  }
}