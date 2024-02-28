package land.sungbin.androidplayground

import kotlinx.collections.immutable.persistentListOf

fun main() {
  val a = persistentListOf(1, 2, 3)
  val b = persistentListOf(1, 2, 3)

  println(a == b)
}
