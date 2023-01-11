package land.sungbin.androidplayground

import androidx.compose.runtime.snapshots.StateObject
import androidx.compose.runtime.snapshots.StateRecord
import androidx.compose.runtime.snapshots.readable
import androidx.compose.runtime.snapshots.writable

fun <A, B> mutableStatePairOf(first: A, second: B): SnapshotMutablePair<A, B> {
    return SnapshotMutablePairImpl(first, second)
}

private class SnapshotMutablePairImpl<A, B>(
    first: A,
    second: B,
) : StateObject, SnapshotMutablePair<A, B> {
    private var next = SnapshotPairRecord(first, second)

    override var value: Pair<A, B>
        get() = next.readable(this).asPair()
        set(value) {
            next.writable(this) {
                first = value.first
                second = value.second
            }
        }

    override var firstValue: A
        get() = next.readable(this).first
        set(value) {
            next.writable(this) { first = value }
        }

    override var secondValue: B
        get() = next.readable(this).second
        set(value) {
            next.writable(this) { second = value }
        }

    override val firstStateRecord: StateRecord
        get() = next

    override fun prependStateRecord(value: StateRecord) {
        @Suppress("UNCHECKED_CAST")
        next = value as SnapshotPairRecord<A, B>
    }

    private class SnapshotPairRecord<A, B>(
        var first: A,
        var second: B,
    ) : StateRecord() {
        override fun create(): StateRecord {
            return SnapshotPairRecord(first, second)
        }

        override fun assign(value: StateRecord) {
            @Suppress("UNCHECKED_CAST")
            (value as SnapshotPairRecord<A, B>).let { record ->
                first = record.first
                second = record.second
            }
        }

        fun asPair() = first to second
    }
}
