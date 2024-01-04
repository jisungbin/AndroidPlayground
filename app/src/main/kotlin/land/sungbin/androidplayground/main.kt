package land.sungbin.androidplayground

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.Snapshot
import androidx.compose.runtime.snapshots.SnapshotMutableState

fun main() {
  Snapshot.registerGlobalWriteObserver { stateObject ->
    stateObject as SnapshotMutableState<*>
    println("written: ${stateObject.value}")
  }

  var intState by mutableIntStateOf(0)
  var stringState by mutableStateOf("Hello")

  repeat(10) {
    intState++
    stringState += stringState
  }
}
