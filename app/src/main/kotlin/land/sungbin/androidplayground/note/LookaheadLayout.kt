@file:NoLiveLiterals
@file:OptIn(ExperimentalComposeUiApi::class)

package land.sungbin.androidplayground.note

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.AnimationVector2D
import androidx.compose.animation.core.VectorConverter
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.LookaheadLayout
import androidx.compose.ui.layout.LookaheadLayoutScope
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

private fun Modifier.animateConstraints(lookaheadScope: LookaheadLayoutScope) = composed {
    var sizeAnimation: Animatable<IntSize, AnimationVector2D>? by remember {
        mutableStateOf(null)
    }
    var targetSize: IntSize? by remember { mutableStateOf(null) }

    LaunchedEffect(Unit) {
        snapshotFlow { targetSize }.collect { target ->
            if (target != null && target != sizeAnimation?.targetValue) {
                sizeAnimation?.run {
                    launch { animateTo(target) }
                } ?: Animatable(target, IntSize.VectorConverter).let {
                    sizeAnimation = it
                }
            }
        }
    }

    with(lookaheadScope) {
        this@composed.intermediateLayout { measurable, _, lookaheadSize ->
            targetSize = lookaheadSize
            val (width, height) = sizeAnimation?.value ?: lookaheadSize
            val animatedConstraints = Constraints.fixed(width, height)
            val placeable = measurable.measure(animatedConstraints)
            layout(placeable.width, placeable.height) {
                placeable.place(0, 0)
            }
        }
    }
}

@Composable
fun LookaheadLayoutExample() {
    LookaheadLayout(
        content = {
            var fullWidth by remember { mutableStateOf(false) }

            Row(
                modifier = (if (fullWidth) Modifier.fillMaxWidth() else Modifier.width(100.dp))
                    .height(200.dp)
                    .animateConstraints(this)
                    .clickable { fullWidth = !fullWidth }
            ) {
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight()
                        .background(Color.Red)
                )
                Box(
                    modifier = Modifier
                        .weight(2f)
                        .fillMaxHeight()
                        .background(Color.Yellow)
                )
            }
        }
    ) { measurables, constraints ->
        val placeables = measurables.map { it.measure(constraints) }
        val maxWidth = placeables.maxOf { it.width }
        val maxHeight = placeables.maxOf { it.height }
        layout(maxWidth, maxHeight) {
            placeables.forEach {
                it.place(0, 0)
            }
        }
    }
}
