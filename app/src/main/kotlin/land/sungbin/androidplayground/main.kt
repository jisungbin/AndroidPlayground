package land.sungbin.androidplayground

import kotlin.concurrent.thread

private val lock = Object()
private var ref: Any? = Any()

fun main() {
  println("START...")

  thread { deleter() }
  assigner()

  println("END...")
}

private fun deleter() {
  synchronized(lock) {
    Thread.sleep(3000)
    ref = null
    lock.notifyAll()
  }
}

private fun assigner() {
  synchronized(lock) {
    println("[assigner] awaiting...")
    while (ref != null) lock.wait()
    println("[assigner] Assigned!")
  }
}