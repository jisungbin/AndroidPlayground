@file:Suppress("MayBeConstant")
@file:NoLiveLiterals

package land.sungbin.androidplayground.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.NoLiveLiterals
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import land.sungbin.texts_list.Texts

private val texts = mutableStateListOf<String>()

class PlaygroundActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var state by remember { mutableStateOf(false) }

            Texts(texts) {
                if (state) {
                    Button(modifier = Modifier.lg("A"), onClick = { state = !state }) {
                        Text(
                            text = "A",
                        )
                    }
                } else {
                    Button(modifier = Modifier.lg("B"), onClick = { state = !state }) {
                        Text(
                            text = "B",
                        )
                    }
                }
            }
        }
    }
}

fun Modifier.lg(key: String) = composed {
    DisposableEffect(Unit) {
        texts.add(key)
        onDispose {
            texts.remove(key)
        }
    }
    this
}
