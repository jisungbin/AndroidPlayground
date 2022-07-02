package land.sungbin.androidplayground.snippet.animation

import androidx.annotation.DrawableRes
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import land.sungbin.androidplayground.R
import land.sungbin.androidplayground.extension.and
import land.sungbin.androidplayground.theme.Pink

const val AnimationDuration = 5000
fun <T> defaultTween() = tween<T>(
    durationMillis = AnimationDuration,
    easing = LinearEasing
)

@Immutable
data class TabColors(
    val defaultBackground: Color = Color.White,
    val selectedBackground: Color = Color.Pink,
    val defaultText: Color = Color.Gray,
    val selectedText: Color = Color.Black
)

object TabDefaults {
    val Items = listOf(
        "토르" to R.drawable.thor_poster and "토르: 러브 앤 썬더",
        "거미맨" to R.drawable.spiderman_poster and "스파이더맨: 노 웨이 홈",
        "의사" to R.drawable.doctor_poster and "닥터 스트레인지: 대혼돈의 멀티버스"
    )
    val Color = TabColors()
}

@Stable
fun tabBackgroundColor(
    selectedIndex: Int,
    nowTabIndex: Int
) = when (selectedIndex == nowTabIndex) {
    true -> TabDefaults.Color.selectedBackground
    false -> TabDefaults.Color.defaultBackground
}

@Stable
fun tabTextColor(
    selectedIndex: Int,
    nowTabIndex: Int
) = when (selectedIndex == nowTabIndex) {
    true -> TabDefaults.Color.selectedText
    false -> TabDefaults.Color.defaultText
}

@Stable
fun posterContainerHeight(index: Int) = listOf(500, 550, 600)[index].dp

@Composable
fun tabBackgroundColorWithAnimation(
    selectedIndex: Int,
    nowTabIndex: Int
) = animateColorAsState(
    targetValue = when (selectedIndex == nowTabIndex) {
        true -> TabDefaults.Color.selectedBackground
        false -> TabDefaults.Color.defaultBackground
    },
    animationSpec = defaultTween()
).value

@Composable
fun tabTextColorWithAnimation(
    selectedIndex: Int,
    nowTabIndex: Int
) = animateColorAsState(
    targetValue = when (selectedIndex == nowTabIndex) {
        true -> TabDefaults.Color.selectedText
        false -> TabDefaults.Color.defaultText
    },
    animationSpec = defaultTween()
).value

@Stable
fun searchTabIndexByDrawable(@DrawableRes drawable: Int) = when (drawable) {
    R.drawable.thor_poster -> 0
    R.drawable.spiderman_poster -> 1
    R.drawable.doctor_poster -> 2
    else -> throw IllegalStateException("Drawable $drawable is not supported.")
}
