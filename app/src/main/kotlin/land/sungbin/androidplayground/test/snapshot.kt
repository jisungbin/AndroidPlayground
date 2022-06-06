@file:Suppress(
    "UNUSED_VARIABLE",
    "LocalVariableName",
    "ASSIGNED_BUT_NEVER_ACCESSED_VARIABLE",
    "UNUSED_VALUE",
    "unused",
    "UNCHECKED_CAST",
    "UNUSED_PARAMETER"
)

package land.sungbin.androidplayground.test

import androidx.compose.runtime.ControlledComposition
import androidx.compose.runtime.SnapshotMutationPolicy
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.MutableSnapshot
import androidx.compose.runtime.snapshots.Snapshot
import androidx.compose.runtime.snapshots.StateRecord
import androidx.compose.ui.platform.AndroidUiDispatcher
import java.util.concurrent.atomic.AtomicBoolean
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.launch

private var value by mutableStateOf(
    value = "",
    policy = object : SnapshotMutationPolicy<String> {
        // a: previous
        // b: current
        // previous 랑 current 랑 값이 같은지 체크
        // 값이 달라야 스냅샷 업데이트를 진행함
        override fun equivalent(a: String, b: String): Boolean {
            // println("equivalent: a: $a, b: $b")
            return a == b
        }

        // previous: 스냅샷을 캡쳐했을 당시의 루트 값
        // current: 현재의 루트 값
        // applied: 적용하려고 하는 값
        // previous != current 일 때 호출되며, 루트 값이 변경되었기에
        // 현재의 applied 값이 정확할 것이라고 판단할 수 없어
        // 직접 병합 방법을 정의해 주어야 함
        override fun merge(previous: String, current: String, applied: String): String =
            "merged: previous: $previous, current: $current, applied: $applied"
    }
)


@JvmInline
private value class IdWrapper(val id: Int)

private fun currentSnapshot() = IdWrapper(1)

interface StateObject {
    // LinkedList 에서 첫 번째 StateRecord
    val firstStateRecord: StateRecord

    // LinkedList 시작 부분에 새 StateRecord 를 추가
    fun prependStateRecord(value: StateRecord)

    // 스냅샷이 충돌했을 때 병합하기 위한 방법
    fun mergeRecords(
        previous: StateRecord,
        current: StateRecord,
        applied: StateRecord,
    ): StateRecord? = null
}

abstract class StateRecord {
    // StateRecord 가 생성된 스냅샷의 아이디
    internal var snapshotId: Int = currentSnapshot().id

    // 다음 StateRecord
    internal var next: StateRecord? = null

    // 다른 StateRecord 에서 값 복사
    abstract fun assign(value: StateRecord)

    // StateRecord 생성
    abstract fun create(): StateRecord
}

private class StateStateRecord<T>(myValue: T) : StateRecord() {
    override fun assign(value: StateRecord) {
        this.value = (value as StateStateRecord<T>).value
    }

    override fun create(): StateRecord = StateStateRecord(value)

    var value: T = myValue
}

// 스냅샷이 충돌했을 때 병합하기 위한 방법을 정의합니다.
fun mergeRecords(
    previous: StateRecord,
    current: StateRecord,
    applied: StateRecord,
): StateRecord? = null

interface SnapshotMutationPolicy<T> {
    // 새 StateRecord 값과 이전 StateRecord 값의 일치 비교
    // 만약 값이 같다면 새로운 레코드를 만들지 않는다.
    fun equivalent(a: T, b: T): Boolean

    // previous: 스냅샷을 캡쳐했을 당시의 StateRecord 값
    // current: 현재의 StateRecord 값
    // applied: 적용하려고 한 StateRecord 값
    // 스냅샷 충돌을 해결하기 위한 병합 방법
    fun merge(previous: T, current: T, applied: T): T? = null
}

object ReferentialEqualityPolicy : SnapshotMutationPolicy<Any?> {
    override fun equivalent(a: Any?, b: Any?) = a === b
}

object StructuralEqualityPolicy : SnapshotMutationPolicy<Any?> {
    override fun equivalent(a: Any?, b: Any?) = a == b
}

object NeverEqualPolicy : SnapshotMutationPolicy<Any?> {
    override fun equivalent(a: Any?, b: Any?) = false
}

internal object GlobalSnapshotManager {
    private val started = AtomicBoolean(false)

    fun ensureStarted() {
        if (started.compareAndSet(false, true)) {
            val channel = Channel<Unit>(Channel.CONFLATED)
            CoroutineScope(AndroidUiDispatcher.Main).launch {
                channel.consumeEach {
                    Snapshot.sendApplyNotifications()
                }
            }
            Snapshot.registerGlobalWriteObserver {
                channel.trySend(Unit)
            }
        }
    }
}

/*fun main() {
    var age by mutableStateOf(
        value = 1,
        policy = object : SnapshotMutationPolicy<Int> {
            override fun equivalent(a: Int, b: Int) = a == b
            override fun merge(previous: Int, current: Int, applied: Int) =
                "$previous$current$applied".toInt()
        }
    )
    val snap1 = Snapshot.takeMutableSnapshot()
    val snap2 = Snapshot.takeMutableSnapshot()
    snap1.enter {
        age = 10
        age = 12
    }
    snap1.apply()
    snap2.enter {
        age = 20
    }
    snap2.apply()
    println(age) // 11220 (previous: 1, current: 12, applied: 20)
}*/

fun main() {
    var age by mutableStateOf(1)
    age = 21
}

private inline fun <T> composing(
    composition: ControlledComposition,
    modifiedValues: IdentityArraySet<Any>?,
    block: () -> T,
): T {
    val snapshot = Snapshot.takeMutableSnapshot(
        readObserverOf(composition), writeObserverOf(composition, modifiedValues)
    )
    try {
        return snapshot.enter(block)
    } finally {
        applyAndCheck(snapshot)
    }
}


/*fun main() {
    var age by mutableStateOf(1)
    val snap1 = Snapshot.takeMutableSnapshot()
    val snap2 = Snapshot.takeMutableSnapshot()
    println(age) // 1
    // ..
    snap2.enter {
        age = 20
        println(age) // 20
    }
    snap2.apply()
    snap2.dispose()
    println(age) // 12
}*/

fun applyAndCheck(snapshot: MutableSnapshot) {
    TODO("Not yet implemented")
}

fun writeObserverOf(
    composition: ControlledComposition,
    modifiedValues: IdentityArraySet<Any>?,
): ((Any) -> Unit)? {
    TODO("Not yet implemented")
}

fun readObserverOf(composition: ControlledComposition): ((Any) -> Unit)? {
    TODO("Not yet implemented")
}

class IdentityArraySet<T> {

}

private operator fun Any.invoke() {
    println(toString())
}

fun assert(boolean: Boolean) {
    if (!boolean) throw AssertionError("Assertion failed.")
}