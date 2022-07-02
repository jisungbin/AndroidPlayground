@file:NoLiveLiterals

package land.sungbin.androidplayground.snippet.animation

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.NoLiveLiterals
import androidx.compose.runtime.Stable
import androidx.compose.ui.graphics.Color
import land.sungbin.androidplayground.R
import land.sungbin.androidplayground.extension.and
import land.sungbin.androidplayground.theme.Pink

const val DefaultCornerUnit = 30
const val AnimationDuration = 500

@Immutable // maybe?
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

    @Stable
    val Color = TabColors()
}
