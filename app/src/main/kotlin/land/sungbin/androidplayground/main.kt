package land.sungbin.androidplayground

import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
  val value = CompletableDeferred<Long>()
  println("Enter: ${System.currentTimeMillis()}")

  delay(3000)
  value.complete(System.currentTimeMillis())

  println("One is ${value.await()}")
  println("Two is ${value.await()}")
  println("Three is ${value.await()}")
}
