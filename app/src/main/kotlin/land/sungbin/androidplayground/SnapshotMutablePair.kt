package land.sungbin.androidplayground

interface SnapshotMutablePair<A, B> {
    val value: Pair<A, B>
    var firstValue: A
    var secondValue: B
}
