package land.sungbin.androidplayground

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.Snapshot

fun main() {
    var value by mutableStateOf(1)
    println(value)
    val snapshot = Snapshot.takeSnapshot()
    value = 2
    println(value)
    snapshot.enter { // snapshot restore (set value to 1)
        println(value)
    }
    println(value)
    snapshot.dispose()
}