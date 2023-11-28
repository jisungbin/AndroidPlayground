package land.sungbin.androidplayground

object NULL

var a: Any = NULL

fun hasCodeAndMessageLazy(): Int {
  if (a === NULL) a = 1
  return a as Int
}

fun hasCodeAndMessageGetter() = 1
