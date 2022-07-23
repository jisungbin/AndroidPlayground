@file:NoLiveLiterals
@file:Suppress("UNUSED_PARAMETER", "FunctionName")

package land.sungbin.androidplayground.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.compose.runtime.NoLiveLiterals
import kotlinx.coroutines.CancellableContinuation

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}

private fun deriveStateLocked(): CancellableContinuation<Unit>? {
    // 보류 중인 작업: 리컴포지션 요청 등등 컴포즈 런타임 내부에서 진행되는 여러 작업 요청

    val newState = when { /* 현재 보류 중인 작업 여부에 따라 새로운 상태 계산 */ }
    return if (newState == State.PendingWork) { // 보류 중인 작업이 있다면
        workContinuation.also { // workContinuation 반환 및 workContinuation 초기화
            workContinuation = null
        }
    } else null
}