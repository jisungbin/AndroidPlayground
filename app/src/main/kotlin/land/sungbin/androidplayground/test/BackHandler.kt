package land.sungbin.androidplayground.test

import androidx.activity.compose.BackHandler
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@Composable
fun BackHandlerTest() {
    var isBackPressed by remember { mutableStateOf(false) }

    BackHandler(!isBackPressed) {
        isBackPressed = true
    }

    Text("뒤로가기 눌림: $isBackPressed")
}

@Composable
private fun DummyBackHandler() {

    var isBackPressed by remember { mutableStateOf(false) }

    BackHandler(enabled = !isBackPressed) {
        isBackPressed = true
    }

    Text("뒤로가기 눌림: $isBackPressed")
}
