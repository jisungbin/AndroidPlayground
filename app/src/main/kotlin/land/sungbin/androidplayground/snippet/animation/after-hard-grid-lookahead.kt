@file:NoLiveLiterals
@file:OptIn(ExperimentalComposeUiApi::class, ExperimentalComposeUiApi::class)

package land.sungbin.androidplayground.snippet.animation

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.AnimationVector2D
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.VectorConverter
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.NoLiveLiterals
import androidx.compose.runtime.Stable
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
import land.sungbin.androidplayground.snippet.animation.component.MoviePoster

private object PosterSize {
    @Stable
    val Vertical = DpSize(
        width = 180.dp,
        height = 220.dp
    )

    @Stable
    val Horizontal = DpSize(
        width = 120.dp,
        height = 200.dp
    )
}

private fun Modifier.layoutTransitionAnimation(
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

@BackgroundPreview
@Composable
fun HardLookaheadMovieGrid() {
    var isInColumn by remember { mutableStateOf(true) }

    val items = remember {
        movableContentWithReceiverOf<LookaheadLayoutScope> {
            TabDefaults.Items.forEach { tab ->
                val (tabType, tabPosterDrawable, _) = tab
                MoviePoster(
                    modifier = Modifier
                        .size(
                            size = when (isInColumn) {
                                true -> PosterSize.Vertical
                                false -> PosterSize.Horizontal
                            }
                        )
                        .layoutTransitionAnimation(
                            lookaheadScope = this,
                            animationSpec = spring(
                                dampingRatio = Spring.DampingRatioMediumBouncy,
                                stiffness = Spring.StiffnessMediumLow,
                            )
                        ),
                    fillMaxSize = false,
                    posterDrawable = tabPosterDrawable,
                    posterDescription = tabType.string
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
