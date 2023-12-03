package land.sungbin.androidplayground

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf

fun main() {
  val state = (mutableStateOf(0) as State<*>).value
  println(state)
}
