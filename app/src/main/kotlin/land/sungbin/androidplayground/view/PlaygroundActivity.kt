@file:NoLiveLiterals

package land.sungbin.androidplayground.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.NoLiveLiterals

@Immutable
class ImmutableClass {
    val list = listOf(1, 2, 3)
}

class PlaygroundActivity : ComponentActivity() {
    val immutableClass = ImmutableClass()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Text(text = numberToString2(1))
        }
    }
}

@Composable
fun NumberToString(a: () -> Int) {
    Text(text = a().toString())
}

fun numberToString2(a: Int) = a.toString()
