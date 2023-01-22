@file:NoLiveLiterals

package land.sungbin.androidplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.NoLiveLiterals
import androidx.compose.runtime.NonRestartableComposable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.layout.Layout

class PlaygroundActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Test()
        }
    }
}

@Composable
@NonRestartableComposable
fun Test() {
    var value by remember { mutableStateOf(1) }
    SimpleLayout {
        Button(onClick = { value++ }) {
            Text(text = value.toString())
        }
    }
}

@Composable
fun SimpleLayout(content: @Composable () -> Unit) {
    Layout(content = content) { _, _ ->
        layout(0, 0) {}
    }
}
