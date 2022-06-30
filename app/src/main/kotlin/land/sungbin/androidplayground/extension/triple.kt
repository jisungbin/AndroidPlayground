package land.sungbin.androidplayground.extension

infix fun <A, B, C> Pair<A, B>.and(that: C) = Triple(first, second, that)