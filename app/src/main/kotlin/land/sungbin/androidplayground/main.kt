package land.sungbin.androidplayground

fun main() {
  var map = mapOf(Any() to 1, Any() to 5, Any() to 3, Any() to 6)
  map = map.toSortedMap(compareBy { map[it]!! })
  println(map)
}
