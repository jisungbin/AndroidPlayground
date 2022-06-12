@file:NoLiveLiterals
@file:Suppress("SpellCheckingInspection")

package land.sungbin.androidplayground.test

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.NoLiveLiterals
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

@Composable
fun DonutholeSkippingTest() {
    SideEffect {
        println("main 함수 컴포지션됨")
    }

    var number by remember { mutableStateOf(0) }

    /*LoggingButton(
        logMessage = "Button 컴포지션됨",
        onClick = { number++ }
    ) {
        SideEffect {
            println("Button content 컴포지션됨")
        }
        LoggingText(
            text = number.toString(),
            logMessage = "Text 컴포지션됨"
        )
    }*/

    DonutTextWithLogging(
        modifier = Modifier.clickable { number++ },
        logMessage = "Text 컴포지션됨",
        textLambda = { number.toString() }
    )
}

@Composable
private fun LoggingButton(
    modifier: Modifier = Modifier,
    logMessage: String,
    onClick: () -> Unit,
    content: @Composable RowScope.() -> Unit
) {
    SideEffect {
        println(logMessage)
    }
    Button(
        modifier = modifier,
        onClick = onClick,
        content = content
    )
}

@Composable
private fun LoggingText(
    modifier: Modifier = Modifier,
    text: String,
    logMessage: String
) {
    SideEffect {
        println(logMessage)
    }
    Text(
        modifier = modifier,
        text = text
    )
}

@Composable
private fun DonutTextWithLogging(
    modifier: Modifier = Modifier,
    logMessage: String,
    textLambda: () -> String
) {
    SideEffect {
        println(logMessage)
    }
    Text(
        modifier = modifier,
        text = textLambda()
    )
}
