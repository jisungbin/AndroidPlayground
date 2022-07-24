@file:NoLiveLiterals
@file:Suppress(
    "UNUSED_PARAMETER",
    "FunctionName",
    "UNUSED_VARIABLE"
)

package land.sungbin.androidplayground.view

import androidx.activity.ComponentActivity
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.NoLiveLiterals
import androidx.compose.runtime.movableContentOf
import androidx.compose.runtime.remember

class MainActivity : ComponentActivity() {
    init {
        repeat(10) { index ->
            println("AAA: $index")
        }
    }
}

@Composable
fun MovableContentOf() {
    val content = remember {
        movableContentOf {
            Text(text = System.currentTimeMillis().toString())
        }
    }
}