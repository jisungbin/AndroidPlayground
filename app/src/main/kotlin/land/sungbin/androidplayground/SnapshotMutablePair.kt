package land.sungbin.androidplayground

import javax.annotation.concurrent.Immutable

@Immutable
interface SnapshotMutablePair<A, B> {
    var value: Pair<A, B>
    var firstValue: A
    var secondValue: B
}
