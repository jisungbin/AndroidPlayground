@file:Suppress("unused")

package land.sungbin.androidplayground.test

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.DrawModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.ContentDrawScope
import androidx.compose.ui.unit.dp

private object RealInvisibleModifier : DrawModifier {
    override fun ContentDrawScope.draw() {}
}

// Standard Modifier
private fun Modifier.realInvisible(isHide: Boolean) = when (isHide) {
    true -> then(RealInvisibleModifier)
    else -> this
}

// Composed Modifier
private inline fun Modifier.realNoRippleClickable(crossinline onClick: () -> Unit) = composed {
    clickable(
        indication = null,
        interactionSource = remember { MutableInteractionSource() },
        onClick = { onClick() }
    )
}

@Composable
fun CustomModifierTest() {
    var isHideState by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .size(250.dp)
            .realNoRippleClickable { isHideState = !isHideState }
            .realInvisible(isHideState)
            .background(color = Color.Green)
    )
}

@Composable
private fun DummyCustomModifier() {

    var isInvisibleState by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .realNoRippleClickable { isInvisibleState = !isInvisibleState }
            .realInvisible(isInvisibleState)
            .background(color = Color.Green)
    )
}

fun Modifier.invisible(isInvisible: Boolean) = when (isInvisible) {
    true -> then(RealInvisibleModifier)
    else -> this
}

inline fun Modifier.noRippleClickable(crossinline onClick: () -> Unit) = composed {
    clickable(
        indication = null,
        interactionSource = remember { MutableInteractionSource() },
        onClick = { onClick() }
    )
}

object InvisibleModifier : DrawModifier {
    override fun ContentDrawScope.draw() {}
}
