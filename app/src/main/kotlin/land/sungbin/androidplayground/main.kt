package land.sungbin.androidplayground

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.Snapshot

fun main() {
  var a by mutableFloatStateOf(0f)
  val snapshot = Snapshot.takeSnapshot()
  a = 2f

  println(a)
  snapshot.enter { println(a) }
}