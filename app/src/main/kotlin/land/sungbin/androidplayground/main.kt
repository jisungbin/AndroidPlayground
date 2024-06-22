package land.sungbin.androidplayground

import androidx.compose.runtime.ExperimentalComposeApi
import androidx.compose.runtime.SnapshotMutationPolicy
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.Snapshot

@OptIn(ExperimentalComposeApi::class)
fun main() {
  var a by mutableStateOf(0f, object : SnapshotMutationPolicy<Float> {
    override fun equivalent(a: Float, b: Float): Boolean = a == b

    override fun merge(previous: Float, current: Float, applied: Float): Float {
      println("$previous -> $current -> $applied")
      return applied
    }
  })
  val snapshot = Snapshot.takeMutableSnapshot()
  a = 2f

  println(a)

  val entered = snapshot.unsafeEnter()
  a = 1f

  Snapshot.global { println(a) }

  snapshot.apply().check()
  snapshot.unsafeLeave(entered)
  entered?.dispose()

  println(a)
}