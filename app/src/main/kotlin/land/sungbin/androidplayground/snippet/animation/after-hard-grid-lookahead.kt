@file:NoLiveLiterals
@file:OptIn(ExperimentalComposeUiApi::class)

package land.sungbin.androidplayground.snippet.animation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.NoLiveLiterals
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.LookaheadLayout
import androidx.compose.ui.layout.LookaheadLayoutScope
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.round
import land.sungbin.androidplayground.annotation.BackgroundPreview
import land.sungbin.androidplayground.extension.noRippleClickable
import land.sungbin.androidplayground.preview.BooleanPreview
import land.sungbin.androidplayground.snippet.animation.component.MoviePoster

private fun Modifier.layoutTransition(lookaheadScope: LookaheadLayoutScope) = composed {
    var placementOffset by remember { mutableStateOf(IntOffset.Zero) }
    var targetOffset: IntOffset? by remember { mutableStateOf(null) }

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
                    val (x, y) = targetOffset!! - placementOffset
                    placeable.place(x, y)
                }
            }
    }
}

@BackgroundPreview
@Composable
private fun LookaheadLayoutScope.MovieItem(
    @PreviewParameter(BooleanPreview::class) isInColumn: Boolean
) {
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
                .layoutTransition(lookaheadScope = this),
            fillMaxSize = false,
            posterDrawable = tabPosterDrawable,
            posterDescription = tabType.string
        )
    }
}

@BackgroundPreview
@Composable
fun HardLookaheadMovieGrid() {
    var isInColumn by remember { mutableStateOf(true) }

    LookaheadLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
            .noRippleClickable { isInColumn = !isInColumn },
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
                    content = { MovieItem(isInColumn) }
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
                    content = { MovieItem(isInColumn) }
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
