package land.sungbin.androidplayground

fun main() {
  var target = 0
  val targetGetter = { target }

  println(targetGetter())
  target++
  println(targetGetter())
}