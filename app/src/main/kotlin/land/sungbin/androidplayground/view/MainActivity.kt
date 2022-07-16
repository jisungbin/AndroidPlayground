@file:Suppress("PrivatePropertyName")

package land.sungbin.androidplayground.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            DisplayText("SungbinLand")
            DisplayTexts(listOf("SungbinLand"))
        }
    }
}

@Composable
fun DisplayText(text: String) {
    Text(text = text)
}

@Composable
fun DisplayTexts(text: List<String>) {
    Text(text = text.joinToString())
}