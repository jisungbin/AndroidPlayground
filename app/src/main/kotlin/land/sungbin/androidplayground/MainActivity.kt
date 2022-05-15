@file:Suppress("SetTextI18n", "unused", "OPT_IN_IS_NOT_ENABLED", "SameParameterValue")

package land.sungbin.androidplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.key

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Foo(false, "")
        }
    }

    @Composable
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
    }

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
