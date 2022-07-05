@file:Suppress("KDocUnresolvedReference")

package land.sungbin.androidplayground.snippet.fake

import androidx.compose.animation.Animatable
import androidx.compose.animation.VectorConverter
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.AnimationConstants
import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.CubicBezierEasing
import androidx.compose.animation.core.Easing
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.SpringSpec
import androidx.compose.animation.core.TweenSpec
import androidx.compose.animation.core.animateValueAsState
import androidx.compose.animation.core.spring
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
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

/**
 * 시작 값과 끝 값 사이에 물리학 기반 애니메이션을 적용합니다.
 *
 * @param DampingRatio 스프링의 감쇠비 (탄성)
 * @param stiffness 스프링의 강성 (종료 값으로 이동하는 속도)
 * @param visibleThreshold 가시성 임계값
 * 애니메이션이 대상에 반올림하기에 충분히 시각적으로 가까운 것으로 간주되어야 하는 시기를 정의합니다.
 *
 * @return 주어진 옵션을 사용하는 [SpringSpec]
 */
@Stable
fun <T> spring(
    dampingRatio: Float = Spring.DampingRatioNoBouncy,
    stiffness: Float = Spring.StiffnessMedium,
    visibilityThreshold: T? = null
): SpringSpec<T> = SpringSpec(
    dampingRatio = dampingRatio,
    stiffness = stiffness,
    visibilityThreshold = visibilityThreshold
)

/**
 * 이징 곡선을 사용하여 지정된 [durationMillis] 동안 시작 값과 끝 값 간에 애니메이션을 적용합니다.
 *
 * @param durationMillis 애니메이션 사양의 지속 시간 (밀리초)
 * @param delayMillis 애니메이션이 시작되기 전에 대기하는 시간 (밀리초)
 * @param easing 시작과 끝 사이를 보간하는 데 사용되는 이징 곡선
 *
 * @return 주어진 옵션을 사용하는 [TweenSpec]
 */
@Stable
fun <T> tween(
    durationMillis: Int = AnimationConstants.DefaultDurationMillis,
    delayMillis: Int = 0,
    easing: Easing = FastOutSlowInEasing
): TweenSpec<T> = TweenSpec(
    durationMillis = durationMillis,
    delay = delayMillis,
    easing = easing
)

/**
 * 전환의 끝을 강조하기 위해 빠르게 속도를 높이고 점차적으로 느려집니다.
 */
val FastOutSlowInEasing: Easing = CubicBezierEasing(0.4f, 0.0f, 0.2f, 1.0f)

/**
 * 들어오는 요소는 최고 속도(요소 이동의 가장 빠른 지점)에서 전환을 시작하고 정지 상태에서 끝나는 감속 완화를 사용하여 애니메이션됩니다.
 */
val LinearOutSlowInEasing: Easing = CubicBezierEasing(0.0f, 0.0f, 0.2f, 1.0f)

/**
 * 화면을 종료하는 요소는 정지 상태에서 시작하여 최고 속도로 끝나는 가속 완화를 사용합니다.
 */
val FastOutLinearInEasing: Easing = CubicBezierEasing(0.4f, 0.0f, 1.0f, 1.0f)

/**
 * 수정되지 않은 분수를 반환합니다. [Easing]이 필요하지만 실제 easing 이 필요하지 않은 경우 기본값으로 유용합니다.
 */
val LinearEasing: Easing = Easing { fraction -> fraction }


/**
 * [CubicBezierEasing] 클래스는 3차 베지어 곡선을 구현합니다.
 */
@Immutable
class CubicBezierEasing(
    private val a: Float,
    private val b: Float,
    private val c: Float,
    private val d: Float
) : Easing {
    override fun transform(fraction: Float): Float {
        TODO("Not yet implemented")
    }
}