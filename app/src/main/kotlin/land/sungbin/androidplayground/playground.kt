package land.sungbin.androidplayground

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue


@Composable
fun DelegateOtherComposable() {
    Counter()
}

@Composable
fun Counter() {
    var number by remember { mutableStateOf(1) }
    Button(onClick = { number++ }) {
        Text(text = number.toString())
    }
}