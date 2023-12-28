package land.sungbin.androidplayground

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(): Unit = runBlocking {
  val toggle = MutableStateFlow(true)

  launch {
    toggle.collect { a ->
      while (a) {
        println("a")
        delay(1000)
        if (!toggle.value) break
      }
    }
  }

  delay(5000)
  toggle.emit(false)
  delay(3000)
  toggle.emit(true)
  delay(3000)
  toggle.emit(false)
}