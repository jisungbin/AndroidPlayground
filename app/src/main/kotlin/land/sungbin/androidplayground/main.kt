package land.sungbin.androidplayground

fun main() {
  val list = listOf("하" to true, "가" to true, "라" to false, "다" to true, "나" to false)
  println(list.sortedWith(compareBy({ !it.second }, { it.first })))
}
