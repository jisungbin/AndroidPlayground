package land.sungbin.androidplayground.composable

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.NonRestartableComposable

@NonRestartableComposable
@Composable
fun NonRestartableText() {
    Text(text = "NonRestartableComposable")
}
