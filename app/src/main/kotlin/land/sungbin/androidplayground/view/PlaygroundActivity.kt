@file:Suppress("MayBeConstant")
@file:NoLiveLiterals
@file:OptIn(ExperimentalAnimationApi::class)

package land.sungbin.androidplayground.view

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.NoLiveLiterals
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp

class PlaygroundActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val orientation = LocalConfiguration.current.orientation
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center,
            ) {
                Box(
                    modifier = Modifier
                        .size(size = (orientation * 100).dp)
                        .animateContentSize(
                            animationSpec = tween(
                                durationMillis = 1000,
                                easing = LinearEasing,
                            ),
                        )
                        .rotate(
                            degrees = animateFloatAsState(
                                targetValue = when (orientation) {
                                    Configuration.ORIENTATION_PORTRAIT -> 0f
                                    Configuration.ORIENTATION_LANDSCAPE -> 90f
                                    else -> throw IllegalStateException()
                                },
                                animationSpec = tween(
                                    durationMillis = 1000,
                                    easing = LinearEasing,
                                ),
                            ).value,
                        )
                        .background(
                            color = animateColorAsState(
                                targetValue = when (orientation) {
                                    Configuration.ORIENTATION_PORTRAIT -> Color.Yellow
                                    Configuration.ORIENTATION_LANDSCAPE -> Color.Green
                                    else -> throw IllegalStateException()
                                },
                                animationSpec = tween(
                                    durationMillis = 1000,
                                    easing = LinearEasing,
                                ),
                            ).value.copy(alpha = 0.5f),
                        )
                )
            }
        }
    }
}
