package land.sungbin.androidplayground.view

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun UiNodes() {
    Column {
        repeat(10) { index ->
            Text(text = "My index is $index")
        }
    }
}
