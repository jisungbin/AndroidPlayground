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

lateinit var text: String

fun main() = setContent {
    LoadText()
    ShowText()
}

@Composable
private fun LoadText() {
    text = "Bye, world!"
    Text(text = "Load Text...")
}

@Composable
private fun ShowText() {
    Text(text = text)
}
