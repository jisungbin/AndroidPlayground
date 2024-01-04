package land.sungbin.androidplayground

import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.snapshots.Snapshot
import androidx.compose.runtime.snapshots.StateObject
import androidx.compose.runtime.snapshots.StateRecord
import androidx.compose.runtime.snapshots.withCurrent
import androidx.compose.runtime.snapshots.writable

fun main() {
  val state = mutableIntStateOf(1)
  val stateObject = state as StateObject
  val previousRecord = stateObject.copyCurrentRecord()

  ++state.intValue

  val safeZone = Snapshot.takeMutableSnapshot()
  try {
    safeZone.enter {
      val current = state.intValue
      val previous = run {
        stateObject.restoreFrom(previousRecord)
        state.intValue
      }
      println("current: $current, previous: $previous")
    }
  } finally {
    safeZone.dispose()
  }

  println("state: ${state.intValue}")
}

fun StateObject.copyCurrentRecord(): StateRecord {
  val newRecord = firstStateRecord.create()
  firstStateRecord.withCurrent(newRecord::assign)
  return newRecord
}

fun StateObject.restoreFrom(record: StateRecord) {
  firstStateRecord.writable(this) { assign(record) }
}
