package land.sungbin.androidplayground

import androidx.compose.runtime.snapshots.StateObject
import androidx.compose.runtime.snapshots.StateRecord

internal class SnapshotMutablePairImpl<A, B>(
    first: A,
    second: B,
) : StateObject, SnapshotMutablePair<A, B> {
    override val firstStateRecord: StateRecord = TODO()

    override fun prependStateRecord(value: StateRecord) {
        TODO()
    }

    override var value: Pair<A, B> = TODO()

    override var firstValue: A
        get() = value.first
        set(value) = TODO()

    override var secondValue: B
        get() = value.second
        set(value) = TODO()
}
