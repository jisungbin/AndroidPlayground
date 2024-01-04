package land.sungbin.androidplayground

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.Snapshot
import androidx.compose.runtime.snapshots.SnapshotMutableState

fun main() {
  Snapshot.registerGlobalWriteObserver { stateObject ->
    stateObject as SnapshotMutableState<*>
    println("written: ${stateObject.value}")
  }

  var state by mutableIntStateOf(0)
  repeat(10) {
    state++
  }
}
