@file:OptIn(ExperimentalComposeUiApi::class)

package land.sungbin.androidplayground.note

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.AnimationVector2D
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.VectorConverter
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.movableContentWithReceiverOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.LookaheadLayout
import androidx.compose.ui.layout.LookaheadLayoutScope
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.round
import kotlinx.coroutines.launch
import land.sungbin.androidplayground.annotation.BackgroundPreview

private fun Modifier.layoutTransitionAnimation(lookaheadScope: LookaheadLayoutScope) = composed {
    var targetOffsetAnimation: Animatable<IntOffset, AnimationVector2D>? by remember {
        mutableStateOf(null)
    }

    var placementOffset by remember { mutableStateOf(IntOffset.Zero) }
    var targetOffset: IntOffset? by remember { mutableStateOf(null) }

    LaunchedEffect(Unit) {
        snapshotFlow { targetOffset }.collect { target ->
            if (target != null && target != targetOffsetAnimation?.targetValue) {
                targetOffsetAnimation?.run {
                    launch {
                        animateTo(
                            targetValue = target,
                            animationSpec = spring(
                                dampingRatio = Spring.DampingRatioMediumBouncy,
                                stiffness = Spring.StiffnessVeryLow,
                            )
                        )
                    }
                } ?: Animatable(
                    initialValue = target,
                    typeConverter = IntOffset.VectorConverter
                ).let { offsetAnimatable ->
                    targetOffsetAnimation = offsetAnimatable
                }
            }
        }
    }

    with(lookaheadScope) {
        this@composed
            .onPlaced { lookaheadScopeCoordinates, layoutCoordinates ->
                // localLookaheadPositionOf는 LookaheadLayout의 로컬 좌표에서
                // 이 수정자의 *target* 위치를 반환합니다.
                targetOffset = lookaheadScopeCoordinates
                    .localLookaheadPositionOf(
                        sourceCoordinates = layoutCoordinates
                    )
                    .round()

                // localPositionOf는 LookaheadLayout의 로컬 좌표에서
                // 이 수정자의 *현재* 위치를 반환합니다.
                placementOffset = lookaheadScopeCoordinates
                    .localPositionOf(
                        sourceCoordinates = layoutCoordinates,
                        relativeToSource = Offset.Zero
                    )
                    .round()
            }
            .intermediateLayout { measurable, constraints, _ ->
                // targOffset 이 collect 되서 targetOffsetAnimation 이 초기화 되기 전에
                // 이 블록이 실행될 수 있음?

                // targetOffset 이 layout 안에 들어올 때면 항상 non-null 인데
                // 왜? 인지를 모르겠다.
                // -> 이 intermediateLayout 블럭 4번 실행되고 (배치할 박스가 4개니까)
                // 이후 layout 블럭이 4번 실행 됨.
                // 내부에서 suspend 가 있는건가???
                // 어떻게 비동기로 작동하는 걸까?
                val placeable = measurable.measure(constraints)
                layout(placeable.width, placeable.height) {
                    // 이동한 오프셋에 배치 하려고
                    // targetOffset - placementOffset 하는거 같음
                    val (x, y) = (
                        targetOffsetAnimation?.value ?: targetOffset!!
                        ) - placementOffset
                    placeable.place(x, y)
                }
            }
    }
}

private val colors = listOf(
    Color(0xffff6f69),
    Color(0xffffcc5c),
    Color(0xff264653),
    Color(0xff2a9d84)
)

@BackgroundPreview
@Composable
fun LookaheadLayoutDemo() {
    var isInColumn by remember { mutableStateOf(true) }

    val items = remember {
        movableContentWithReceiverOf<LookaheadLayoutScope> {
            colors.forEach { color ->
                Box(
                    modifier = Modifier
                        .size(
                            size = when (isInColumn) {
                                true -> DpSize(
                                    width = 200.dp,
                                    height = 80.dp
                                )
                                false -> DpSize(
                                    width = 80.dp,
                                    height = 80.dp
                                )
                            }
                        )
                        .layoutTransitionAnimation(this)
                        .background(color, RoundedCornerShape(20))
                )
            }
        }
    }

    LookaheadLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
            .clickable { isInColumn = !isInColumn },
        content = {
            if (isInColumn) {
                Column(
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.spacedBy(
                        space = 30.dp,
                        alignment = Alignment.CenterVertically
                    ),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    content = { items() }
                )
            } else {
                Row(
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(
                        space = 15.dp,
                        alignment = Alignment.CenterHorizontally
                    ),
                    content = { items() }
                )
            }
        }
    ) { measurables, constraints ->
        val placeables = measurables.map { it.measure(constraints) }
        val maxWidth = placeables.maxOf { it.width }
        val maxHeight = placeables.maxOf { it.height }

        layout(width = maxWidth, height = maxHeight) {
            placeables.forEach { placeable ->
                placeable.place(x = 0, y = 0)
            }
        }
    }
}
