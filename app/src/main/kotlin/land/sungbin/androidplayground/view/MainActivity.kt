@file:NoLiveLiterals
@file:Suppress("UNUSED_PARAMETER", "FunctionName")

package land.sungbin.androidplayground.view

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.NoLiveLiterals
import androidx.compose.runtime.key

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Text(text = "")
        }
    }
}

@Composable
fun RestartableGroup() {
    Text(text = "RestartableGroup")
}

@Composable
fun ReplaceableGroup(isColumn: Boolean = true) {
    when (isColumn) {
        true -> Text(text = "Column")
        else -> Text(text = "Row")
    }
}

@Composable
fun MovableGroup() {
    key(Any()) {
        Text(text = "KeyComposable")
    }
}

/**
 * 컴포저블이 배치된 위치가 달라지면 위치 메모이제이션의 key 가 달라져서 데이터가 초기화됩니다.
 * 데이터를 유지한 상태로 위치를 옮기기 위해선 key 컴포저블을 이용해
 * 위치 메모이제이션에서 참고할 key 를 직접 정의해야 합니다.
 *
 * key 컴포저블을 이용해 배치된 컴포저블은 주위로 MovableGroup 이 생성됩니다.
 * MovableGroup 은 컴포저블이 위치 메모이제이션 key 와 데이터를 항상 보존하며 이동하는 방법을 가르칩니다.
 */
@SuppressLint("ComposableNaming")
@Composable
inline fun <T> key(
    vararg keys: Any?,
    block: @Composable () -> T
) {
}