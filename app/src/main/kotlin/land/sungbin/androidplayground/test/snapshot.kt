package land.sungbin.androidplayground.test

import androidx.compose.runtime.SnapshotMutationPolicy
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.Snapshot

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

fun main() {
    value = "GlobalSnapshot value"

    val snapshot = Snapshot.takeMutableSnapshot()
    val snapshot2 = Snapshot.takeMutableSnapshot()

    snapshot2.enter {
        value = "snapshot2 applied"
        snapshot.enter {
            value = "snapshot applied"
        }
    }

    value()
    snapshot2.apply()
    value()
    snapshot.apply()
    value()
}

private operator fun Any.invoke() {
    println(toString())
}
