package land.sungbin.androidplayground

sealed class A {
  class One : A()
  class Two : A()
}

fun main() {
  val one = A.One()
  val two = A.Two()

  println(one.javaClass.canonicalName)
  println(two.javaClass.canonicalName)
}
