package land.sungbin.androidplayground.test

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.platform.LocalContext

private val LocalNormalText = compositionLocalOf { "TEST" }
private val LocalStaticText = staticCompositionLocalOf { "TEST2" }

@Composable
fun CompositionLocalTest() {

    val context = LocalContext.current

    CompositionLocalProvider(
        LocalTextTest provides "MESSAGE"
    ) {
        Text(text = LocalTextTest.current)
    }
}
