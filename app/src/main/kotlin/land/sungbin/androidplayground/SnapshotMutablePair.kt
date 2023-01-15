package land.sungbin.androidplayground

import androidx.compose.runtime.Stable

@Stable
interface SnapshotMutablePair<A, B> {
    var value: Pair<A, B>
    var firstValue: A
    var secondValue: B
}
