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

context(LookaheadLayoutScope)
fun Modifier.animateMovement(
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
            layout(width = placeable.width, height = placeable.height) {
                val (x, y) = (
                        targetOffsetAnimation?.value ?: targetOffset!!
                        ) - placementOffset
                placeable.place(x = x, y = y)
            }
        }
}

context(LookaheadLayoutScope)
fun Modifier.animateTransformation(
    animationSpec: AnimationSpec<IntSize> = defaultSpring()
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
                } ?: Animatable(
                    initialValue = target,
                    typeConverter = IntSize.VectorConverter
                ).let { sizeAnimatable ->
                    targetSizeAnimation = sizeAnimatable
                }
            }
        }
    }

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