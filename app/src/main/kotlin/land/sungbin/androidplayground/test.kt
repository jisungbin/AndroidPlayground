package land.sungbin.androidplayground

fun test(hi: String.() -> Int, bye: Unit.(hi: Int) -> String) {
    "".hi()
    bye(Unit, 1)
}

fun rawTest(hi: Function1<String, Int>, bye: Function2<Unit, Int, String>) {
    hi("test")
    bye(Unit, 1)
}

fun main() {
    test({ 1 }, { "" })
    rawTest({ 1 }, { _, _ -> "" })
}
