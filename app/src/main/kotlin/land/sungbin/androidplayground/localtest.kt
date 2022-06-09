package land.sungbin.androidplayground

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.Snapshot

fun main() {
    var age by mutableStateOf(1)
    val globalSnapshot = Snapshot.takeMutableSnapshot()
    val snap1 = Snapshot.takeMutableSnapshot()
    snap1.enter {
        age = 20
        println("A: $age")
    }
    println("B: $age")
    globalSnapshot.enter {
        println("C: $age")
        snap1.apply()
        println("D: $age")
    }
    println("E: $age")
}