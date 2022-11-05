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
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.FractionalThreshold
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.rememberSwipeableState
import androidx.compose.material.swipeable
import androidx.compose.runtime.Composable
import androidx.compose.runtime.NoLiveLiterals
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import kotlin.math.roundToInt

class PlaygroundActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var text by remember {
                mutableStateOf("")
            }

            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center,
            ) {
                SwipeableTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight(),
                    text = text,
                    onTextChange = { newText ->
                        text = newText
                    },
                )
            }
        }
    }
}

enum class TimeState {
    Future,
    Now,
}

@Composable
fun SwipeableTextField(
    modifier: Modifier = Modifier,
    text: String,
    onTextChange: (String) -> Unit,
) {
    BoxWithConstraints(modifier = modifier) {
        val density = LocalDensity.current

        val textFieldWidth = 120.dp
        val textFieldWidthPx = with(density) { textFieldWidth.toPx() }

        val maxWidthPx = with(density) { maxWidth.toPx() }

        val swipeableState = rememberSwipeableState(
            initialValue = TimeState.Future,
        )
        val anchors = remember {
            mapOf(
                0f to TimeState.Future,
                maxWidthPx - textFieldWidthPx to TimeState.Now,
            )
        }

        val textFieldRounding = 30.dp

        Box(
            modifier = Modifier
                .width(width = maxWidth)
                .wrapContentHeight()
                .swipeable(
                    state = swipeableState,
                    anchors = anchors,
                    thresholds = { _, _ -> FractionalThreshold(fraction = 0.3f) },
                    orientation = Orientation.Horizontal,
                )
                .background(color = Color.LightGray)
        ) {
            TextField(
                modifier = Modifier
                    .width(width = textFieldWidth)
                    .wrapContentHeight()
                    .offset {
                        IntOffset(
                            x = swipeableState.offset.value.roundToInt(),
                            y = 0,
                        )
                    },
                value = text,
                onValueChange = onTextChange,
                shape = RoundedCornerShape(
                    topStart = textFieldRounding,
                    topEnd = textFieldRounding,
                    bottomStart = animateDpAsState(
                        targetValue = when (swipeableState.currentValue == TimeState.Future) {
                            true -> 0.dp
                            false -> textFieldRounding
                        }
                    ).value,
                    bottomEnd = animateDpAsState(
                        targetValue = when (swipeableState.currentValue == TimeState.Future) {
                            true -> textFieldRounding
                            false -> 0.dp
                        },
                    ).value,
                ),
                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                ),
            )
        }
    }
}
