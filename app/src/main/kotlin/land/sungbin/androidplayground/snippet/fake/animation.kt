@file:Suppress("KDocUnresolvedReference")

package land.sungbin.androidplayground.snippet.fake

import androidx.compose.animation.Animatable
import androidx.compose.animation.VectorConverter
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.animateValueAsState
import androidx.compose.animation.core.spring
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color

private val colorDefaultSpring = spring<Color>()

/**
 * [Color] 에 대한 Fire-and-Forget 애니메이션 기능을 제공합니다.
 * animate*AsState 는 [Float], [Color], [Dp], [Size], [Offset], [Rect], [Int], [IntOffset] 그리고 [IntSize] 에 사전 정의돼 있습니다.
 * 제공된 [targetValue] 가 변경되면 애니메이션이 자동으로 실행됩니다.
 * [targetValue] 가 변경될 때 진행 중인 애니메이션이 이미 있는 경우 진행 중인 애니메이션은 새 대상 값을 향해 애니메이션되도록 코스를 조정합니다.
 *
 * animate*AsState 는 [State] 객체를 반환합니다. 상태 개체의 값은 애니메이션이 끝날 때까지 애니메이션에 의해 계속 업데이트됩니다.
 * 이 컴포저블 함수를 제거하지 않고는 애니메이션을 취소할 수 없습니다. 취소 가능한 애니메이션은 [Animatable] 을 사용하세요.
 *
 * @param targetValue 애니메이션의 타겟
 * @param animationSpec 시간에 따라 값을 변경하는 데 사용할 애니메이션
 * @param finishedListener 애니메이션이 완료될 때 알림을 받는 선택적 리스너
 *
 * @return 애니메이션이 적용되는 값을 담은 [State]
 */
@Composable
fun animateColorAsState(
    targetValue: Color,
    animationSpec: AnimationSpec<Color> = colorDefaultSpring,
    finishedListener: ((Color) -> Unit)? = null
): State<Color> {
    val converter = remember(targetValue.colorSpace) {
        // Color.VectorConverter 는 아래와 같은 ColorToVector 를 반환합니다.
        // private val ColorToVector: (colorSpace: ColorSpace) -> TwoWayConverter<Color, AnimationVector4D>
        //
        // 그래서 (Color.VectorConverter)(targetValue.colorSpace) 이 코드는
        // ColorToVector(targetValue.colorSpace) 와 같습니다.
        (Color.VectorConverter)(targetValue.colorSpace)
    }
    return animateValueAsState(
        targetValue = targetValue,
        typeConverter = converter,
        animationSpec = animationSpec,
        finishedListener = finishedListener
    )
}