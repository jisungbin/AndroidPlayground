@file:Suppress(
    "RedundantUnitReturnType",
    "unused",
    "UnusedImport"
)
@file:NoLiveLiterals

package land.sungbin.androidplayground

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.NoLiveLiterals
import androidx.compose.runtime.NonRestartableComposable

lateinit var text: String

fun main() = setContent {
    LoadText()
    ShowText()
}

@NonRestartableComposable
@Composable
private fun LoadText() {
    text = "Bye, world!"
    Text(text = "Load Text...")
}

@Composable
private fun ShowText() {
    Text(text = text)
}
