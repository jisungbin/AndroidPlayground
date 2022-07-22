@file:NoLiveLiterals

package land.sungbin.androidplayground.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.NoLiveLiterals

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /**
         * 멱등성: 같은 연산의 결과는 항상 동일하다는 성질
         *
         * 같은 input 을 받은 컴포저블을 멱등성의 보장으로 항상 재실행을 건너뛴다.
         */
        setContent {
            // 만약 UI 갱신이 필요하다면...

            Text(text = "성빈랜드") // 이 컴포저블은 한 번만 실행됩니다.
            Text(text = System.currentTimeMillis().toString()) // 이 컴포저블은 항상 재실행 됩니다.
        }
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

/**
 * 멱등성: 같은 연산의 결과는 항상 동일하다는 성질
 *
 * 같은 input 을 받은 컴포저블을 멱등성의 보장으로 항상 재실행을 건너뛴다.
 */
@Composable
fun Idempotent() {
    // 만약 UI 갱신이 필요하다면...

    Text(text = "성빈랜드") // 이 컴포저블은 한 번만 실행됩니다.
    Text(text = System.currentTimeMillis().toString()) // 이 컴포저블은 항상 재실행 됩니다.
}

/**
 * 위치 메모이제이션: 같은 위치에서 같은 input 으로 호출되면 항상 같은 output 이 나올 것이라고 가정하고,
 * 값을 캐싱하고 재사용 하는 기술
 *
 * 함수의 시그니처와 call-site, 그리고 호출된 index 를 기준으로 고유한 key 가 생성되고,
 * 해당 key 를 기준으로 컴포즈의 모든 데이터를 저장하고 관리한다.
 *
 * 같은 key 를 가진 컴포저블이 같은 input 으로 호출된다면 기존에 캐싱된 결과를 그대로 재사용한다.
 * -> 멱등성과 위치 메모이제이션의 결과
 */
@Composable
fun PositionMemoization() {
    repeat(5) {
        Text(text = "Bye, world!") // 컴포저블 데이터가 다 다른 공간에 저장됨
    }
}

lateinit var text: String

/**
 * 컴포저블은 무작위 병렬로 실행됨으로 컴포저블의 실행 순서에 의존하는 건 옳지 않다.
 * 따라서 멱등성을 보장하는것이 중요하다.
 */
@Composable
fun PureFunction() {
    LoadText()
    ShowText()
}

@Composable
private fun LoadText() {
    text = "Bye, world!"
    Text(text = "Load Text...")
}

@Composable
private fun ShowText() {
    Text(text = text) // text is not initialized properly 가능성 있음
}

/**
 * @Composable (input) -> output
 * 이 함수의 경우 input 은 리소스 아이디, output 은 리소스 값
 *
 * 이 함수의 @Composable 은 데이터를 제공하는 역할
 */
/*@Composable
fun stringResource(@StringRes id: Int): String {
    val resources = resources()
    return resources.getString(id)
}*/

/**
 * @Composable (input) -> Unit
 * 이 함수의 경우 input 과 output 이 없음
 *
 * 이 함수의 @Composable 은 컴포저블을 방출하는 역할
 */
@Composable
fun ByeWorld() {
    Text(text = "Bye, world!")
}