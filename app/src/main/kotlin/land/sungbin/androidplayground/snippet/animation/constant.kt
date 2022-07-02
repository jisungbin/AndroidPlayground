package land.sungbin.androidplayground.snippet.animation

import androidx.annotation.DrawableRes
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.compose.ui.graphics.Color
import land.sungbin.androidplayground.R
import land.sungbin.androidplayground.extension.and
import land.sungbin.androidplayground.theme.Pink

const val DefaultCornerPercent = 30
const val AnimationDuration = 500

enum class Movie(val string: String) {
    Thor("토르"),
    Spider("거미맨"),
    Doctor("의사");
}

fun <T> defaultTween() = tween<T>(
    durationMillis = AnimationDuration,
    easing = FastOutSlowInEasing
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
        Movie.Thor to R.drawable.thor_poster and "토르: 러브 앤 썬더",
        Movie.Spider to R.drawable.spiderman_poster and "스파이더맨: 노 웨이 홈",
        Movie.Doctor to R.drawable.doctor_poster and "닥터 스트레인지: 대혼돈의 멀티버스"
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
