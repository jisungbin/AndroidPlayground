@file:OptIn(ExperimentalComposeUiApi::class)
@file:Suppress("unused")
@file:NoLiveLiterals

package land.sungbin.androidplayground.extension

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.AnimationVector2D
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.VectorConverter
import androidx.compose.animation.core.spring
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.NoLiveLiterals
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.layout.LookaheadLayoutScope
import androidx.compose.ui.layout.Measurable
import androidx.compose.ui.layout.MeasureResult
import androidx.compose.ui.layout.MeasureScope
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.round
import kotlinx.coroutines.launch

private val Spring.StiffnessDebug
    get() = 1f

private fun <T> defaultSpring() = spring<T>(
    dampingRatio = Spring.DampingRatioLowBouncy,
    stiffness = Spring.StiffnessLow, // default: StiffnessLow
)

inline val DefaultMeasurePolicy: MeasureScope.(measurables: List<Measurable>, constraints: Constraints) -> MeasureResult
    get() = { measurables, constraints ->
        val placeables = measurables.map { measurable -> measurable.measure(constraints) }
        val maxWidth = placeables.maxOf { placeable -> placeable.width }
        val maxHeight = placeables.maxOf { placeable -> placeable.height }

        layout(width = maxWidth, height = maxHeight) {
            placeables.forEach { placeable ->
                placeable.place(x = 0, y = 0)
            }
        }
    }

// for test
fun Modifier.movement(lookaheadScope: LookaheadLayoutScope) = composed {
    var targetOffset: IntOffset? by remember { mutableStateOf(null) } // 배치할 오프셋
    var placementOffset by remember { mutableStateOf(IntOffset.Zero) } // 현재 오프셋

    with(lookaheadScope) {
        this@composed
            .onPlaced { lookaheadScopeCoordinates, layoutCoordinates ->
                // LookaheadLayout 의 로컬 coordinate 에서 이 modifier 의 lookahead 위치를 반환
                targetOffset = lookaheadScopeCoordinates
                    .localLookaheadPositionOf(sourceCoordinates = layoutCoordinates)
                    .round() // 가장 가까운 IntOffset 값으로 오프셋 반올림

                // LookaheadLayout 의 로컬 coordinate 에서 이 modifier 의 현재 위치를 반환
                placementOffset = lookaheadScopeCoordinates
                    .localPositionOf(
                        sourceCoordinates = layoutCoordinates,
                        relativeToSource = Offset.Zero
                    )
                    .round()
            }
            .intermediateLayout { measurable, constraints, _ ->
                val placeable = measurable.measure(constraints)
                layout(width = placeable.width, height = placeable.height) {
                    // 이동한 오프셋에 배치
                    val (x, y) = targetOffset!! - placementOffset
                    placeable.place(x = x, y = y)
                }
            }
    }
}

fun Modifier.animateMovement(
    lookaheadScope: LookaheadLayoutScope,
    animationSpec: AnimationSpec<IntOffset> = defaultSpring()
) = composed {
    var placementOffset by remember { mutableStateOf(IntOffset.Zero) }
    var targetOffset: IntOffset? by remember { mutableStateOf(null) }

    var targetOffsetAnimation: Animatable<IntOffset, AnimationVector2D>? by remember {
        mutableStateOf(null)
    }

    LaunchedEffect(Unit) {
        snapshotFlow { targetOffset }.collect { target ->
            if (target != null && target != targetOffsetAnimation?.targetValue) {
                targetOffsetAnimation?.run {
                    launch {
                        animateTo(
                            targetValue = target,
                            animationSpec = animationSpec
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
                targetOffset = lookaheadScopeCoordinates
                    .localLookaheadPositionOf(sourceCoordinates = layoutCoordinates)
                    .round()

                placementOffset = lookaheadScopeCoordinates
                    .localPositionOf(
                        sourceCoordinates = layoutCoordinates,
                        relativeToSource = Offset.Zero
                    )
                    .round()
            }
            .intermediateLayout { measurable, constraints, _ ->
                val placeable = measurable.measure(constraints)
                layout(placeable.width, placeable.height) {
                    val (x, y) = (
                        targetOffsetAnimation?.value ?: targetOffset!!
                        ) - placementOffset
                    placeable.place(x, y)
                }
            }
    }
}

// for test
fun Modifier.transformation(lookaheadScope: LookaheadLayoutScope) = with(lookaheadScope) {
    intermediateLayout { measurable, _, lookaheadSize ->
        val (width, height) = lookaheadSize // lookahead 크기로 width, height 결정
        val animatedConstraints = Constraints.fixed(
            width = width.coerceAtLeast(0), // 최소 0 으로 설정
            height = height.coerceAtLeast(0)
        )

        val placeable = measurable.measure(animatedConstraints)
        layout(width = placeable.width, height = placeable.height) { // lookahead 크기에 맞게 배치
            placeable.place(x = 0, y = 0)
        }
    }
}

fun Modifier.animateTransformation(
    lookaheadScope: LookaheadLayoutScope,
    animationSpec: AnimationSpec<IntSize> = defaultSpring(),
) = composed {
    var targetSize: IntSize? by remember { mutableStateOf(null) }
    var targetSizeAnimation: Animatable<IntSize, AnimationVector2D>? by remember {
        mutableStateOf(null)
    }

    LaunchedEffect(Unit) {
        snapshotFlow { targetSize }.collect { target ->
            if (target != null && target != targetSizeAnimation?.targetValue) {
                targetSizeAnimation?.run {
                    launch {
                        animateTo(
                            targetValue = target,
                            animationSpec = animationSpec
                        )
                    }
                } ?: Animatable(target, IntSize.VectorConverter).let {
                    targetSizeAnimation = it
                }
            }
        }
    }

    with(lookaheadScope) {
        this@composed.intermediateLayout { measurable, _, lookaheadSize ->
            targetSize = lookaheadSize

            val (width, height) = targetSizeAnimation?.value ?: lookaheadSize
            val animatedConstraints = Constraints.fixed(
                width = width.coerceAtLeast(0),
                height = height.coerceAtLeast(0)
            )

            val placeable = measurable.measure(animatedConstraints)
            layout(width = placeable.width, height = placeable.height) {
                placeable.place(x = 0, y = 0)
            }
        }
    }
}
