@file:Suppress(
    "RedundantUnitReturnType",
    "unused",
    "UnusedImport"
)
@file:NoLiveLiterals

package land.sungbin.androidplayground

import androidx.compose.animation.Animatable
import androidx.compose.animation.core.updateTransition
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.NoLiveLiterals
import androidx.compose.runtime.movableContentOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.simulateHotReload
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.MeasureScope

fun main() = setContent {
    val animatable = remember {
        Animatable(Color.Black)
    }
    val transition = updateTransition(targetState = Color.Red, label = "")

    LaunchedEffect(Unit) {
        animatable.animateTo(Color.Blue)
    }
}
