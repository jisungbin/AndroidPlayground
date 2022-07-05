@file:Suppress("UNUSED_VARIABLE")

package land.sungbin.androidplayground.snippet.animation

import androidx.compose.animation.core.AnimationConstants
import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.CubicBezierEasing
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.animateIntOffsetAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.repeatable
import androidx.compose.animation.core.snap
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import land.sungbin.androidplayground.annotation.BackgroundPreview
import land.sungbin.androidplayground.composable.SortedColumn
import land.sungbin.androidplayground.extension.and
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

@Composable
fun KeyframesExample(target: Int) {
    val value by animateIntAsState(
        targetValue = target, // 0 ~ 100
        animationSpec = keyframes {
            durationMillis = 1000 // 1000 ms 동안 애니메이션 진행
            100 at 50 with LinearEasing // LinearEasing 을 사용하며 100 ms 안에 50 까지 애니메이션
            500 at 80 with FastOutSlowInEasing // FastOutSlowInEasing 을 사용하며 500 ms 안에 80 까지 애니메이션
            // 이후 501 ~ 1000 ms 동안 기존에 설정한 이징인 FastOutSlowInEasing 를 계속 사용하여 100 까지 애니메이션
        }
    )
}

@Composable
fun RepeatableExample(target: Int) {
    val value by animateIntAsState(
        targetValue = target,
        animationSpec = repeatable(
            iterations = 3, // 3번 반복
            animation = tween(
                durationMillis = 300,
                easing = LinearEasing
            ), // 300 ms 동안 LinearEasing 으로 애니메이션
            repeatMode = RepeatMode.Reverse // 되감기하며 반복
        )
    )
}

@Composable
fun InfiniteRepeatableExample(target: Int) {
    val value by animateIntAsState(
        targetValue = target,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 300,
                easing = LinearEasing
            ), // 300 ms 동안 LinearEasing 으로 애니메이션
            repeatMode = RepeatMode.Reverse // 되감기하며 반복
        )
    )
}

@Composable
fun SnapExample(target: Int) {
    val value by animateIntAsState(
        targetValue = target,
        animationSpec = snap(delayMillis = 100) // 100 ms 후에 즉시 애니메이션 종료
        // 예를 들어 0 ~ 100 사이의 값을 설정하면 100 ms 후에 즉시 100 으로 애니메이션 종료
    )
}
