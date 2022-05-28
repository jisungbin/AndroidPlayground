package land.sungbin.androidplayground.test

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf

private val LocalTextTest = compositionLocalOf { "TEST" }

@Composable
fun CompositionLocalTest() {
    CompositionLocalProvider(
        LocalTextTest provides "MESSAGE"
    ) {
        Text(text = LocalTextTest.current)
    }
}