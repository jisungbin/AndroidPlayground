package land.sungbin.androidplayground.view

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.MutableLiveData

@Composable
fun UiNodes() {
    Column {
        repeat(10) { index ->
            Text(text = "My index is $index")
        }
    }
}

enum class State {
    AA
}

class AwesomeViewModel {
    val state = MutableLiveData<Int>()
}
