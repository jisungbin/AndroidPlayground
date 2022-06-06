@file:Suppress("PackageDirectoryMismatch")

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.produceState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import kotlinx.coroutines.delay
import land.sungbin.androidplayground.LoadState
import land.sungbin.androidplayground.MainViewModel
import land.sungbin.androidplayground.test.setContent

fun main() {
    setContent {
        var wantChar by remember { mutableStateOf('가') }
        LaunchedEffect(Unit) {
            delay(1000)
            wantChar = '나'
        }
        ShowWantChar(wantChar)
    }
}

@Composable
fun ShowWantChar(wantChar: Char) {
    val chars = remember { '가'..'힣' }
    val wantCharState by rememberUpdatedState(wantChar)
    val foundChar by remember(chars) {
        derivedStateOf { chars.find { it == wantCharState } }
    }
    Text(foundChar.toString())
}

@Composable
fun ItemLoad(vm: MainViewModel) {
    val loadState by produceState<LoadState>(initialValue = LoadState.Loading, key1 = vm) {
        value = vm.loadItems()
    }
    Text(
        text = when (loadState) {
            LoadState.Loading -> "Loading..."
            LoadState.Done -> "Done!"
        }
    )
}

@Composable
fun ShowValue(value: Any) {
    val valueState by rememberUpdatedState(value)
    Text(valueState.toString())
}