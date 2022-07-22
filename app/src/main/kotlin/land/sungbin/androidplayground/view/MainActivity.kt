@file:NoLiveLiterals

package land.sungbin.androidplayground.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.NoLiveLiterals

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /*setContent {
            Column {
                Texts()
            }
        }*/
    }
}

/**
 * Composable 어노테이션은 컴포즈 함수에서 필수적으로 사용되며 크게 2가지의 역할을 갖는다.
 *
 * 1. 위치 메모이제이션
 * 2. 데이터 제공 또는 컴포저블 방출
 */
@MustBeDocumented
@Retention(AnnotationRetention.BINARY)
@Target(
    AnnotationTarget.FUNCTION,
    AnnotationTarget.TYPE,
    AnnotationTarget.TYPE_PARAMETER,
    AnnotationTarget.PROPERTY_GETTER
)
annotation class Composable

@Composable
fun Texts() {
    repeat(5) {
        Text(text = "Bye, world!")
    }
}