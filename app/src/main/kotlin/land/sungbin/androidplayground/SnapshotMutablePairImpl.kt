package land.sungbin.androidplayground

import androidx.compose.runtime.snapshots.StateObject
import androidx.compose.runtime.snapshots.StateRecord

internal class SnapshotMutablePairImpl<A, B> : StateObject, SnapshotMutablePair<A, B> {
    override val firstStateRecord: StateRecord = TODO()

    override fun prependStateRecord(value: StateRecord) {
        TODO()
    }

    override val value: Pair<A, B> = TODO()

    override var firstValue: A = TODO()

    override var secondValue: B = TODO()
}
