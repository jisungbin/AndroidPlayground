package land.sungbin.androidplayground

import androidx.compose.runtime.snapshots.Snapshot
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
  Snapshot.registerApplyObserver { anies, snapshot ->  }
}
