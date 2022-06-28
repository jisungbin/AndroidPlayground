@file:OptIn(ExperimentalFoundationApi::class)

package land.sungbin.androidplayground.theme

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.OverscrollConfiguration
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material.ripple.RippleTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val RedRippleTheme = object : RippleTheme {
    private val contentColor = Color.Red

    @Composable
    override fun defaultColor() = RippleTheme.defaultRippleColor(
        contentColor = contentColor,
        lightTheme = true
    )

    @Composable
    override fun rippleAlpha() = RippleTheme.defaultRippleAlpha(
        contentColor = contentColor,
        lightTheme = true
    )
}

val RedOverscrollConfiguration = OverscrollConfiguration(
    glowColor = Color.Red
)

val RedTextSelectionColors = TextSelectionColors(
    handleColor = Color.Blue.copy(alpha = 0.2f),
    backgroundColor = Color.Red.copy(alpha = 0.2f)
)