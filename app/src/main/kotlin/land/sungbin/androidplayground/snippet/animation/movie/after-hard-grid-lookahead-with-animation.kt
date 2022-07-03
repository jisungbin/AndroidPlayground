@file:NoLiveLiterals
@file:OptIn(ExperimentalComposeUiApi::class)

package land.sungbin.androidplayground.snippet.animation.movie

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
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
import androidx.compose.runtime.movableContentWithReceiverOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.LookaheadLayout
import androidx.compose.ui.layout.LookaheadLayoutScope
import androidx.compose.ui.unit.dp
import land.sungbin.androidplayground.annotation.BackgroundPreview
import land.sungbin.androidplayground.extension.layoutTransitionAnimation
import land.sungbin.androidplayground.extension.noRippleClickable
import land.sungbin.androidplayground.snippet.animation.movie.component.MoviePoster

@BackgroundPreview
@Composable
fun HardLookaheadMovieGridWithAnimation() {
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
