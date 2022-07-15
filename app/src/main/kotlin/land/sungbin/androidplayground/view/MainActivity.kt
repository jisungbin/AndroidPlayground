@file:NoLiveLiterals

package land.sungbin.androidplayground.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.NoLiveLiterals
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            println("0")
            Column { // inline -> same recomposition scope with setContent
                var number by remember { mutableStateOf(1) }
                var number2 by remember { mutableStateOf(1) }
                Text(text = "number").also { println("1") }
                Textt(
                    modifier = Modifier.clickable { number++ },
                    text = number.toString() // everytime change instance -> recomposition
                ).also { println("2") }
                Texttt( // skippable
                    modifier = Modifier.clickable { number2++ },
                    text = { number2.toString() } // always same instance, only change invoke value -> skip recomposition
                ).also { println("3") }
            }
        }
    }
}


@Composable
fun Textt(
    modifier: Modifier = Modifier,
    text: String
) {
    Text(
        modifier = modifier,
        text = text
    ).also {
        println("Textt: ${text.hashCode()}")
    }
}

@Composable
fun Texttt(
    modifier: Modifier = Modifier,
    text: () -> String
) {
    Text(
        modifier = modifier,
        text = text().also { println("Texttt value: ${it.hashCode()}") } // only change value(invoke) instance
    ).also {
        println("Texttt: ${text.hashCode()}") // not change reference instance
    }
}