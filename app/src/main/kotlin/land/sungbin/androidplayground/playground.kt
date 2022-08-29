package land.sungbin.androidplayground

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.NonRestartableComposable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@Composable
@NonRestartableComposable
fun DelegateOtherComposable() {
    Counter().also { println("Counter called") }
}

@Composable
fun Counter() {
    var number by remember { mutableStateOf(1) }
    Button(onClick = { number++ }) {
        Text(text = number.toString()).also { println("Text called") }
    }.also { println("Button called") }
}