@file:Suppress(
    "UNUSED_PARAMETER",
    "FunctionName",
    "UNUSED_VARIABLE"
)

package land.sungbin.androidplayground.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HelloWorld()
        }
    }

    @Composable
    fun HelloWorld() {
        Text(text = "Hello, World!!!!!!!!!", style = TextStyle(color = Color.Red))
    }
}