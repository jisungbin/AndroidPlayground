package land.sungbin.androidplayground

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.currentRecomposeScope
import androidx.compose.ui.Modifier

@Composable
fun RecomposeScopeTest() {
    val recomposeScope = currentRecomposeScope
    SideEffect {
        println("Recomposed Test")
    }
    Box(
        modifier = Modifier.clickable {
            recomposeScope.invalidate()
            println("Invalidate!")
        }
    )
}

@Composable
fun LoggingButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    content: @Composable RowScope.() -> Unit,
) {
    SideEffect {
        println("Recomposed Button")
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
    text: String,
) {
    SideEffect {
        println("Recomposed Text")
    }
    Text(
        modifier = modifier,
        text = text
    )
}