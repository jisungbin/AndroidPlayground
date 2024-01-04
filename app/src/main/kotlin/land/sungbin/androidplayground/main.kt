package land.sungbin.androidplayground

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.Snapshot

fun main() {
  (1..10).forEach loop@{ number ->
    if (number % 2 == 0) return@loop
    println(number)
  }
}
