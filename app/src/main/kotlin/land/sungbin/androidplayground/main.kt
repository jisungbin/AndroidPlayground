package land.sungbin.androidplayground

import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

fun main(): Unit = runBlocking {
  var count = 0
  flow { while (++count < 10) emit(count) }.collect(::println)
  count = 0
}