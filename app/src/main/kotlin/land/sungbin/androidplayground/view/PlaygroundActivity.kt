@file:Suppress(
    "MayBeConstant", "UNUSED_ANONYMOUS_PARAMETER", "UNUSED_VARIABLE",
    "KotlinRedundantDiagnosticSuppress", "UnnecessaryOptInAnnotation"
)
@file:NoLiveLiterals
@file:OptIn(ExperimentalAnimationApi::class, ExperimentalMaterialApi::class)

package land.sungbin.androidplayground.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.FractionalThreshold
import androidx.compose.material.rememberSwipeableState
import androidx.compose.material.swipeable
import androidx.compose.runtime.Composable
import androidx.compose.runtime.NoLiveLiterals
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import kotlin.math.roundToInt

class PlaygroundActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.Center,
            ) {
                SwipeableSample()
            }
        }
    }
}

@Composable
fun SwipeableSample() {
    val density = LocalDensity.current

    val squareSize = 48.dp
    val squareSizePx = with(density) { squareSize.toPx() }

    val fullWidht = LocalConfiguration.current.screenWidthDp.dp
    val fullWidhtPx = with(density) { fullWidht.toPx() }

    val swipeableState = rememberSwipeableState(0)
    val anchors = mapOf(
        0f to 0,
        fullWidhtPx - squareSizePx to 1,
    )



    Box(
        modifier = Modifier
            .width(fullWidht)
            .swipeable(
                state = swipeableState,
                anchors = anchors,
                thresholds = { _, _ -> FractionalThreshold(0.3f) },
                orientation = Orientation.Horizontal
            )
            .background(Color.LightGray)
    ) {
        Box(
            Modifier
                .offset { IntOffset(swipeableState.offset.value.roundToInt(), 0) }
                .size(squareSize)
                .background(Color.DarkGray)
        )
    }
}

@Composable
fun SwipeableTextField(
    text: String,
    onTextChange: (String) -> Unit,
) {

}
