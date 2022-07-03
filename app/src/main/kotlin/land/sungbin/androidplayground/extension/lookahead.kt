@file:OptIn(ExperimentalComposeUiApi::class)

package land.sungbin.androidplayground.extension

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.AnimationVector2D
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.VectorConverter
import androidx.compose.animation.core.spring
import androidx.compose.runtime.LaunchedEffect
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
import androidx.compose.ui.unit.round
import kotlinx.coroutines.launch

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

fun Modifier.layoutTransition(lookaheadScope: LookaheadLayoutScope) = composed {
    var placementOffset by remember { mutableStateOf(IntOffset.Zero) }
    var targetOffset: IntOffset? by remember { mutableStateOf(null) }

    with(lookaheadScope) {
        this@composed
            .onPlaced { lookaheadScopeCoordinates, layoutCoordinates ->
                println("onPlaced.")
                targetOffset = lookaheadScopeCoordinates
                    .localLookaheadPositionOf(
                        sourceCoordinates = layoutCoordinates
                    )
                    .round()

                placementOffset = lookaheadScopeCoordinates
                    .localPositionOf(
                        sourceCoordinates = layoutCoordinates,
                        relativeToSource = Offset.Zero
                    )
                    .round()
            }
            .intermediateLayout { measurable, constraints, _ ->
                println("intermediateLayout.")
                val placeable = measurable.measure(constraints)
                layout(placeable.width, placeable.height) {
                    val (x, y) = targetOffset!! - placementOffset
                    placeable.place(x, y)
                }
            }
    }
}

fun Modifier.layoutTransitionAnimation(
    lookaheadScope: LookaheadLayoutScope,
    animationSpec: AnimationSpec<IntOffset> = spring(
        dampingRatio = Spring.DampingRatioMediumBouncy,
        stiffness = Spring.StiffnessVeryLow,
    )
) = composed {
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
                    .localLookaheadPositionOf(
                        sourceCoordinates = layoutCoordinates
                    )
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
