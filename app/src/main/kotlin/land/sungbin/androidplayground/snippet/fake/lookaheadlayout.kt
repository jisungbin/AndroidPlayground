@file:Suppress("UNUSED_PARAMETER", "KDocUnresolvedReference")

package land.sungbin.androidplayground.snippet.fake

import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.UiComposable
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.layout.AlignmentLine
import androidx.compose.ui.layout.LayoutModifier
import androidx.compose.ui.layout.Measurable
import androidx.compose.ui.layout.MeasurePolicy
import androidx.compose.ui.layout.MeasureResult
import androidx.compose.ui.layout.MeasureScope
import androidx.compose.ui.layout.onPlaced
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.IntSize

/**
 * 레이아웃을 결정하기 위해 measure 를 미리 하고 추후 placement 단계를 실행하는 레이아웃입니다. => measure 를 미리 하는 단계: lookahead 단계
 * lookahead 단계가 끝나면 추후 [LookaheadLayoutScope.intermediateLayout] 을 통해
 * lookahead 결과를 기반으로 레이아웃의 measurement 및 placement 를 조정할 수 있는 또 다른 measure 및 placement 단계가 시작됩니다. => intermediate layout
 *
 * 이를 이용하여 레이아웃이 미리 measure 된 대상 레이아웃을 향해 크기와 위치를 점차적으로 변경할 수 있습니다.
 *
 * @param content 표시할 composable content
 * @param modifier 레이아웃에 적용할 [Modifier]
 * @param measurePolicy 레이아웃의 measurement 와 positioning 에서 사용할 정책
 */
@ExperimentalComposeUiApi
@UiComposable
@Composable
fun LookaheadLayout(
    content: @Composable @UiComposable LookaheadLayoutScope.() -> Unit,
    modifier: Modifier = Modifier,
    measurePolicy: MeasurePolicy
) {
}

/**
 * [LookaheadLayout] 의 모든(직접 및 간접) 자식 레이아웃에 대한 receiver 범위를 제공합니다.
 * lookahead 단계에서 계산된 레이아웃의 measurement 및 placement 는
 * [LookaheadLayoutScope] 에서 각각 [Modifier.intermediateLayout] 및 [Modifier.onPlaced] 를 통해 observe 할 수 있습니다.
 */
@ExperimentalComposeUiApi
interface LookaheadLayoutScope {
    /**
     * intermediate layout 이 배치될 위치가 계산된 후 호출됩니다.
     *
     * [LookaheadLayoutCoordinates] 가 주어지면 계신된 intermediate layout 의 오프셋과 현재 배치돼 있는 content 의 오프셋을
     * [LookaheadLayoutCoordinates.localLookaheadPositionOf] 와 [LookaheadLayoutCoordinates.localPositionOf] 를 사용하여 얻을 수 있습니다.
     * 이를 통해 계산된 intermedidate layout 의 오프셋을 기반으로 content 의 배치를 조정할 수 있습니다.
     *
     * [onPlaced 람다 인자]
     *
     * @param [lookaheadScopeCoordinates] [LookaheadLayout] 이 사용하는 [LookaheadLayoutCoordinates]
     * @param [layoutCoordinates] 이 modifier 의 컴포저블이 사용하는 [LookaheadLayoutCoordinates]
     */
    fun Modifier.onPlaced(
        onPlaced: (
            lookaheadScopeCoordinates: LookaheadLayoutCoordinates,
            layoutCoordinates: LookaheadLayoutCoordinates
        ) -> Unit
    ): Modifier

    /**
     * lookahead 단계에서 계산된 정보를 기반으로 intermediate layout 를 배치합니다.
     * intermediate layout 의 크기가 제공되는 람다인 [measure] 인자를 통해 intermediate layout 를 morph 할 수 있습니다.
     *
     * morph: 햔재 모양을 다른 모양으로 바꾸는 것
     *
     * [measure 람다 인자]
     *
     * @param [measurable] intermediate layout 의 measurable
     * @param [constraints] intermediate layout 의 constraints
     * @param [lookaheadSize] intermediate layout 의 크기
     *
     * @return [MeasureResult] measure 결과
     */
    fun Modifier.intermediateLayout(
        measure: MeasureScope.(
            measurable: Measurable,
            constraints: Constraints,
            lookaheadSize: IntSize
        ) -> MeasureResult
    ): Modifier
}

/**
 * lookhead 단계 진행 전과 후의 레이아웃 모두의 [LayoutCoordinates] 를 보유합니다.
 */
@ExperimentalComposeUiApi
sealed interface LookaheadLayoutCoordinates : LayoutCoordinates {
    /**
     * [sourceCoordinates] 공간의 [relativeToSource] 를 로컬 coordinate 로 변환합니다.
     * [sourceCoordinates] 는 동일한 레이아웃 계층에 속하는 모든 [LookaheadLayoutCoordinates] 일 수 있습니다.
     *
     * [localPositionOf] 와 달리 [localLookaheadPositionOf] 는 coordinate 계산을 위해 lookahead 위치를 사용합니다.
     *
     * @param [sourceCoordinates] 변환할 [Offset] 이 있는 [LookaheadLayoutCoordinates]
     * @param [relativeToSource] 변활할 [Offset]
     *
     * @return [Offset] 로컬 coordinate 로 변환된 [Offset]
     */
    fun localLookaheadPositionOf(
        sourceCoordinates: LookaheadLayoutCoordinates,
        relativeToSource: Offset = Offset.Zero
    ): Offset
}

/**
 * 레이아웃에 대해 measure 된 bounds 의 홀더입니다.
 */
@JvmDefaultWithCompatibility
interface LayoutCoordinates {
    val size: IntSize
    val providedAlignmentLines: Set<AlignmentLine>
    val parentLayoutCoordinates: LayoutCoordinates?
    val parentCoordinates: LayoutCoordinates?
    val isAttached: Boolean
    fun windowToLocal(relativeToWindow: Offset): Offset
    fun localToWindow(relativeToLocal: Offset): Offset
    fun localToRoot(relativeToLocal: Offset): Offset

    /**
     * [sourceCoordinates] 공간의 [relativeToSource] 를 로컬 coordinate 로 변환합니다.
     * [sourceCoordinates] 는 동일한 레이아웃 계층에 속하는 모든 [LayoutCoordinates] 일 수 있습니다.
     *
     * @param [sourceCoordinates] 변환할 [Offset] 이 있는 [LayoutCoordinates]
     * @param [relativeToSource] 변활할 [Offset]
     *
     * @return [Offset] 로컬 coordinate 로 변환된 [Offset]
     */
    fun localPositionOf(sourceCoordinates: LayoutCoordinates, relativeToSource: Offset): Offset
    fun localBoundingBoxOf(sourceCoordinates: LayoutCoordinates, clipBounds: Boolean = true): Rect
    operator fun get(alignmentLine: AlignmentLine): Int
}
