@file:Suppress("SetTextI18n", "unused", "OPT_IN_IS_NOT_ENABLED", "SameParameterValue")

package land.sungbin.androidplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                TextFieldTest(text = stringResource(R.string.app_name))
            }
        }
    }

    @Composable
    private fun TextFieldTest(text: String) {
        var textState by remember { mutableStateOf(text) }
        TextField(value = textState, onValueChange = { textState = it })
    }

    /*@Composable
    fun Foo(tf: Boolean, text: String) {
        when (tf) {
            true -> {
                key(1, 2) {
                    Text(text = text)
                }
            }
            else -> {
                key(1, 2) {
                    Text(text = text)
                }
            }
        }
    }*/

    /*@Composable
//    @NonRestartableComposable
    private fun RecompositionGenerator() {
        SideEffect {
            println("Composition: RecompositionGenerator function")
        }

        var number by remember { mutableStateOf(0) }

        // Both recomposition RecompositionGenerator function and Text scope.
        // --- result ---
        // [first-composition]
        // Composition: RecompositionGenerator function
        // Composition: Text function
        // [re-composition]
        // Composition: RecompositionGenerator function
        // Composition: Text function
        LoggingText(
            modifier = Modifier.clickable { number++ },
            text = number.toString(),
            // logMessage = "Composition: Text function"
        )

        // Only recomposition Button scope.
        // --- result ---
        // [first-composition]
        // Composition: RecompositionGenerator function
        // Composition: Button scope
        // Composition: Text function
        // [re-composition]
        // Composition: Button scope
        // Composition: Text function
        *//*Button(onClick = { number++ }) {
            SideEffect {
                println("Composition: Button scope")
            }
            LoggingText(
                text = number.toString(),
                logMessage = "Composition: Text function"
            )
        }*//*
    }

    @Composable
//    @NonRestartableComposable
    private fun LoggingText(
        modifier: Modifier = Modifier,
        text: String,
        logMessage: String = "This is Awesome Logging Message.",
    ) {
        SideEffect {
            println(logMessage)
        }
        Text(modifier = modifier, text = text)
    }*/
}

/*
@Composable
fun RecompositionGenerator() {
    SideEffect {
        println("Composition: RecompositionGenerator function")
    }

    var number by remember { mutableStateOf(0) }

    Button(onClick = { number++ }) {
        SideEffect {
            println("Composition: Button scope")
        }
        LoggingText(
            text = number.toString(),
            logMessage = "Composition: Text function"
        )
    }
}

@Composable
private fun LoggingText(modifier: Modifier = Modifier, text: String, logMessage: String) {
    SideEffect {
        println(logMessage)
    }
    Text(modifier = modifier, text = text)
}
*/
