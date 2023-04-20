package land.sungbin.androidplayground.test01

import land.sungbin.androidplayground.test02.TestValue

fun prt(
    value: TestValue? = TestValue.Hi,
    value2: Int = 0,
) {
    println(value.toString() + value2)
}
