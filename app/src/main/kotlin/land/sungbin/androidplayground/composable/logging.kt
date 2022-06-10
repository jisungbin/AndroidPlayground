package land.sungbin.androidplayground.composable

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier

@Composable
fun LoggingButton(
    modifier: Modifier = Modifier,
    log: String = "Button composition.",
    onClick: () -> Unit,
    content: @Composable RowScope.() -> Unit
) {
    SideEffect {
        println(log)
    }
    Button(
        modifier = modifier,
        onClick = onClick,
        content = content
    )
}

@Composable
fun LoggingText(
    modifier: Modifier = Modifier,
    log: String = "Text composition.",
    text: String
) {
    SideEffect {
        println("Text composition.")
    }
    Text(
        modifier = modifier,
        text = text
    )
}