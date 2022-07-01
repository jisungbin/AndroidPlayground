package land.sungbin.androidplayground.extension

operator fun Any.invoke() {
    println("TestLog: $this")
}
