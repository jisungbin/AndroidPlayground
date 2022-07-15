@file:NoLiveLiterals

package land.sungbin.androidplayground.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.NoLiveLiterals
import androidx.compose.ui.res.stringResource
import land.sungbin.androidplayground.R

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /*setContent {
            var number by remember { mutableStateOf(0) }
            println("setContent recomposition")
            Button(onClick = { number++ }) {
                Text(
                    text = number.toString(),
                ).also { println("Text recomposition") }
            }.also { println("Button recomposition") }
        }

        setContent {
            var number by remember { mutableStateOf(0) }
            println("setContent recomposition")
            Text(
                modifier = Modifier.clickable { number++ },
                text = number.toString(),
            ).also { println("Text recomposition") }
        }*/

        setContent {
            TextWrapper(text = stringResource(R.string.sungbin_land))
        }
    }
}

@Composable
fun TextWrapper(text: String) {
    Text(text = text)
}