@file:NoLiveLiterals

package land.sungbin.androidplayground.snippet.animation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.NoLiveLiterals
import androidx.compose.runtime.Stable
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import land.sungbin.androidplayground.wrapper.rememberToast

private object ImageSize {
    @Stable
    val Vertical = DpSize(
        width = 140.dp,
        height = 180.dp
    )

    @Stable
    val Horizontal = DpSize(
        width = 100.dp,
        height = 220.dp
    )
}

@Composable
fun HardLookaheadMovieGrid() {
    val toast = rememberToast()
}
