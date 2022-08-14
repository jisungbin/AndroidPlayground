package land.sungbin.androidplayground

import androidx.activity.ComponentActivity
import androidx.compose.foundation.interaction.InteractionSource
import androidx.compose.material.ButtonElevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.State
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

class EmptyActivity : ComponentActivity()

@Stable
private class Elevation(
    private val defaultElevation: Dp = 1.dp,
    private val pressedElevation: Dp = 1.dp,
    private val disabledElevation: Dp = 1.dp,
    private val hoveredElevation: Dp = 1.dp,
    private val focusedElevation: Dp = 1.dp,
) : ButtonElevation {
    @Composable
    override fun elevation(enabled: Boolean, interactionSource: InteractionSource): State<Dp> {
        throw NotImplementedError()
    }
}

fun main() {
    val one = Elevation()
    val two = Elevation()
    println(one == two)
    println(one === two)
}