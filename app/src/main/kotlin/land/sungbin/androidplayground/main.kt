package land.sungbin.androidplayground

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.Snapshot

fun main() {
    var value by mutableStateOf(1)
    var state: MutableState<Int>? = null
    val snapshot = Snapshot.takeMutableSnapshot(
        writeObserver = { stateObject ->
            @Suppress("UNCHECKED_CAST")
            (stateObject as? MutableState<Int>)?.let {
                state = stateObject
            }
        },
    )
    val targetValue = snapshot.enter { value = 2; state!!.value }
    snapshot.dispose()
    val initialValue = state!!.value
    println(initialValue to targetValue)
}
