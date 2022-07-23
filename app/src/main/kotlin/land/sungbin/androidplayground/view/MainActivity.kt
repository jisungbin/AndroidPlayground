@file:NoLiveLiterals
@file:Suppress("UNUSED_PARAMETER", "FunctionName")

package land.sungbin.androidplayground.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import androidx.compose.runtime.CompositionContext
import androidx.compose.runtime.NoLiveLiterals
import kotlin.coroutines.CoroutineContext

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Text(text = "SungbinLand")
        }
    }
}

/**
 * 리컴포지션을 수행하고 하나 이상의 컴포저블에 업데이트를 적용하기 위한 스케줄러 입니다.
 */
class Recomposer(
    effectCoroutineContext: CoroutineContext
) : CompositionContext()