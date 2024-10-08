@file:OptIn(ExperimentalAnimatableApi::class)

package land.sungbin.androidplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.DeferredTargetAnimation
import androidx.compose.animation.core.ExperimentalAnimatableApi
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.getValue
import androidx.compose.runtime.movableContentOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.LookaheadScope
import androidx.compose.ui.layout.approachLayout
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.round

class PlaygroundActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      LookaheadScope {
        var isColumn by remember { mutableStateOf(true) }
        val items = remember {
          movableContentOf {
            Box(
              Modifier
                .animating(lookaheadScope = this)
                .surfacing(color = Color.Yellow, inColumn = isColumn),
            )
            Box(
              Modifier
                .animating(lookaheadScope = this)
                .surfacing(color = Color.Green, inColumn = isColumn),
            )
            Box(
              Modifier
                .animating(lookaheadScope = this)
                .surfacing(color = Color.Blue, inColumn = isColumn),
            )
          }
        }

        if (isColumn) {
          Column(
            modifier = Modifier
              .fillMaxSize()
              .clickable { isColumn = !isColumn },
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally,
          ) {
            items()
          }
        } else {
          Row(
            modifier = Modifier
              .fillMaxSize()
              .clickable { isColumn = !isColumn },
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround,
          ) {
            items()
          }
        }
      }
    }
  }
}

private fun Modifier.animating(lookaheadScope: LookaheadScope): Modifier = composed {
  val coroutineScope = rememberCoroutineScope()
  val sizeAnimation = remember { DeferredTargetAnimation(IntSize.VectorConverter) }
  val offsetAnimation = remember { DeferredTargetAnimation(IntOffset.VectorConverter) }

  approachLayout(
    isMeasurementApproachInProgress = { lookaheadSize ->
      sizeAnimation.updateTarget(
        lookaheadSize,
        coroutineScope = coroutineScope,
        animationSpec = spring(stiffness = Spring.StiffnessVeryLow)
      )
      !sizeAnimation.isIdle
    },
    isPlacementApproachInProgress = { lookaheadCoordinates ->
      val target = with(lookaheadScope) {
        lookaheadScopeCoordinates.localLookaheadPositionOf(lookaheadCoordinates)
      }
      offsetAnimation.updateTarget(
        target.round(),
        coroutineScope = coroutineScope,
        animationSpec = spring(stiffness = Spring.StiffnessVeryLow),
      )
      !offsetAnimation.isIdle
    },
  ) { measurable, constraints ->
    val (targetWidth, targetHeight) = sizeAnimation.updateTarget(
      lookaheadSize,
      coroutineScope = coroutineScope,
      animationSpec = spring(stiffness = Spring.StiffnessVeryLow),
    )
    val animatedConstraints = Constraints.fixed(targetWidth, targetHeight)
    val placeable = measurable.measure(animatedConstraints)

    layout(placeable.width, placeable.height) {
      val coordinates = coordinates
      if (coordinates != null) {
        val target = with(lookaheadScope) {
          lookaheadScopeCoordinates.localLookaheadPositionOf(coordinates)
        }
        val animatedOffset = offsetAnimation.updateTarget(
          target.round(),
          coroutineScope = coroutineScope,
          animationSpec = spring(stiffness = Spring.StiffnessVeryLow),
        )
        val placementOffset = with(lookaheadScope) {
          lookaheadScopeCoordinates.localPositionOf(coordinates)
        }

        val (x, y) = animatedOffset - placementOffset.round()
        placeable.place(x, y)
      } else {
        placeable.place(0, 0)
      }
    }
  }
}

private fun Modifier.surfacing(color: Color, inColumn: Boolean): Modifier =
  this
    .clip(RoundedCornerShape(percent = 15))
    .background(color = color)
    .size(size = if (inColumn) 100.dp else 50.dp)
