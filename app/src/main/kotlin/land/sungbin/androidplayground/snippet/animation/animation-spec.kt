package land.sungbin.androidplayground.snippet.animation

import androidx.compose.animation.core.AnimationConstants
import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.CubicBezierEasing
import androidx.compose.animation.core.Easing
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateIntOffsetAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.TextUnitType.Companion.Sp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import land.sungbin.androidplayground.annotation.BackgroundPreview
import land.sungbin.androidplayground.composable.SortedColumn
import land.sungbin.androidplayground.extension.and
import land.sungbin.androidplayground.snippet.animation.movie.defaultTween
import land.sungbin.androidplayground.theme.NanumGothicTextStyle
import land.sungbin.androidplayground.theme.Pink

@BackgroundPreview
@Composable
fun SpringPlayground() {
    var startAnimation by remember {
        mutableStateOf(false)
    }

    val animators = remember {
        listOf(
            "DampingRatioHighBouncy" to Spring.DampingRatioHighBouncy and Spring.StiffnessLow,
            "DampingRatioMediumBouncy" to Spring.DampingRatioMediumBouncy and Spring.StiffnessLow,
            "DampingRatioLowBouncy" to Spring.DampingRatioLowBouncy and Spring.StiffnessLow,
            "StiffnessHigh" to Spring.DampingRatioNoBouncy and Spring.StiffnessHigh,
            "StiffnessMedium" to Spring.DampingRatioNoBouncy and Spring.StiffnessMedium,
            "StiffnessLow" to Spring.DampingRatioNoBouncy and Spring.StiffnessLow
        )
    }

    SortedColumn {
        animators.forEach { (label, bouncy, stiffness) ->
            Animator(
                modifier = Modifier.fillMaxWidth(),
                label = label,
                spec = spring(
                    dampingRatio = bouncy,
                    stiffness = stiffness
                ),
                startAnimation = startAnimation
            )
        }

        Button(
            onClick = { startAnimation = !startAnimation },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Pink)
        ) {
            Text(
                text = "Toogle Animation",
                style = NanumGothicTextStyle.copy(fontSize = 12.sp)
            )
        }
    }
}

@BackgroundPreview
@Composable
fun TweenPlayground() {
    var startAnimation by remember {
        mutableStateOf(false)
    }

    val animators = remember {
        listOf(
            "FastOutSlowInEasing" to FastOutSlowInEasing,
            "LinearOutSlowInEasing" to LinearOutSlowInEasing,
            "FastOutLinearInEasing" to FastOutLinearInEasing,
            "LinearEasing" to LinearEasing,
            "CubicBezierEasing (EaseInBack)" to CubicBezierEasing(
                a = 0.36f,
                b = 0f,
                c = 0.66f,
                d = -0.56f
            )
        )
    }

    SortedColumn {
        animators.forEach { (label, easing) ->
            Animator(
                modifier = Modifier.fillMaxWidth(),
                label = label,
                spec = tween(
                    durationMillis = AnimationConstants.DefaultDurationMillis,
                    easing = easing
                ),
                startAnimation = startAnimation
            )
        }

        Button(
            onClick = { startAnimation = !startAnimation },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Pink)
        ) {
            Text(
                text = "Toogle Animation",
                style = NanumGothicTextStyle.copy(fontSize = 12.sp)
            )
        }
    }
}

@Composable
private fun Animator(
    modifier: Modifier = Modifier,
    label: String,
    spec: AnimationSpec<IntOffset>,
    startAnimation: Boolean
) {
    val localDensity = LocalDensity.current

    val backgroundBoxWidthDp = 250.dp
    val backgroundBoxWidthPx = remember {
        with(localDensity) {
            backgroundBoxWidthDp.toPx()
        }.toInt()
    }
    val backgroundBoxStartPaddingPx = remember {
        with(localDensity) {
            30.dp.toPx()
        }.toInt()
    }
    val dotSizePx = remember {
        with(localDensity) {
            10.dp.toPx()
        }.toInt()
    }

    val intOffsetAnimation by animateIntOffsetAsState(
        targetValue = when (startAnimation) {
            true -> IntOffset(
                x = backgroundBoxWidthPx + backgroundBoxStartPaddingPx - dotSizePx * 2,
                y = 0
            )
            else -> IntOffset(
                x = backgroundBoxStartPaddingPx,
                y = 0
            )
        },
        animationSpec = spec
    )

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            modifier = Modifier.padding(start = 30.dp),
            text = label,
            style = NanumGothicTextStyle.copy(
                color = Color.Black,
                fontSize = 16.sp
            )
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(20.dp)
        ) {
            Box(
                modifier = Modifier
                    .padding(start = 30.dp)
                    .width(backgroundBoxWidthDp)
                    .height(20.dp)
                    .background(color = Color.LightGray)
            )
            Box(
                modifier = Modifier
                    .size(20.dp)
                    .offset { intOffsetAnimation }
                    .background(color = Color.Pink)
            )
        }
    }
}