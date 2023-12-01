package land.sungbin.androidplayground

sealed interface A {
  data object First
  data object Second
}

fun main() {
  val values = listOf(A.Second, A.First)
  val sortedValues = values.sortedByDescending { it is A.First }
  println(sortedValues)
}
