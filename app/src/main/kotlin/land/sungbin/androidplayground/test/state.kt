@file:Suppress("PackageDirectoryMismatch")

import androidx.compose.material.Text
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
        var isEven by remember {
            mutableStateOf(false)
        }
        LaunchedEffect(Unit) {
            delay(1000)
            isEven = true
        }
        NumberFilter(isEven)
    }
}

@Composable
fun NumberFilter(isEven: Boolean) {
    val number = remember { 1..10 }
    val isEvenState by rememberUpdatedState(isEven)
    val filteredNumber by remember(number) {
        derivedStateOf {
            number.filter {
                it % 2 == when (isEvenState) {
                    true -> 0
                    else -> 1
                }
            }
        }
    }
    Text(filteredNumber.joinToString(", "))
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
