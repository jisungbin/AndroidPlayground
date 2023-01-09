package land.sungbin.androidplayground

interface SnapshotMutablePair<A, B> {
    var value: Pair<A, B>
    var firstValue: A
    var secondValue: B
}
