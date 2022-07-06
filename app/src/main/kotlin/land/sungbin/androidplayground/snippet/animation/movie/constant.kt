@file:NoLiveLiterals

package land.sungbin.androidplayground.snippet.animation.movie

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.NoLiveLiterals
import androidx.compose.runtime.Stable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import land.sungbin.androidplayground.R
import land.sungbin.androidplayground.extension.and

typealias Tab = Triple<Movie, Int, String>

val Tab.type get() = first
val Tab.poster get() = second
val Tab.fullname get() = third
val Tab.shortname get() = type.string
val Tab.index get() = type.index

const val DefaultCornerUnit = 30
const val AnimationDuration = 1000

// for tab selected background color (needs transparent color)
private val Color.Companion.TransparentPink
    @Stable
    get() = Red.copy(alpha = 0.2f)

@Immutable
enum class Movie(val string: String) {
    Thor("토르"),
    Spider("거미맨"),
    Doctor("의사");

    private val tab get() = TabDefaults.Items[ordinal]
    val fullname get() = tab.fullname
    val poster get() = tab.poster
    val index get() = ordinal
}

object PosterSize {
    @Stable
    val Vertical = DpSize(
        width = 180.dp,
        height = 220.dp
    )

    @Stable
    val Horizontal = DpSize(
        width = 120.dp,
        height = 200.dp
    )
}

fun <T> defaultTween() = tween<T>(
    durationMillis = AnimationDuration,
    easing = FastOutSlowInEasing
)

@Immutable
data class TabColors(
    val defaultBackground: Color = Color.White,
    val selectedBackground: Color = Color.TransparentPink,
    val defaultText: Color = Color.Gray,
    val selectedText: Color = Color.Black,
)

object TabDefaults {
    val Items = listOf(
        Movie.Thor to R.drawable.thor_poster and "토르: 러브 앤 썬더",
        Movie.Spider to R.drawable.spiderman_poster and "스파이더맨: 노 웨이 홈",
        Movie.Doctor to R.drawable.doctor_poster and "닥터 스트레인지: 대혼돈의 멀티버스"
    )

    @Stable
    val Color = TabColors()
}


@Stable
fun tabBackgroundColor(
    selectedTab: Tab,
    nowTab: Tab,
): Color = when (selectedTab == nowTab) {
    true -> TabDefaults.Color.selectedBackground
    false -> TabDefaults.Color.defaultBackground
}

@Stable
fun tabTextColor(
    selectedTab: Tab,
    nowTab: Tab,
): Color = when (selectedTab == nowTab) {
    true -> TabDefaults.Color.selectedText
    false -> TabDefaults.Color.defaultText
}

@Composable
fun tabBackgroundColorWithAnimation(
    selectedTab: Tab,
    nowTab: Tab,
): Color = animateColorAsState(
    targetValue = when (selectedTab == nowTab) {
        true -> TabDefaults.Color.selectedBackground
        false -> TabDefaults.Color.defaultBackground
    },
    animationSpec = defaultTween()
).value

@Composable
fun tabTextColorWithAnimation(
    selectedTab: Tab,
    nowTab: Tab,
): Color = animateColorAsState(
    targetValue = when (selectedTab == nowTab) {
        true -> TabDefaults.Color.selectedText
        false -> TabDefaults.Color.defaultText
    },
    animationSpec = defaultTween()
).value