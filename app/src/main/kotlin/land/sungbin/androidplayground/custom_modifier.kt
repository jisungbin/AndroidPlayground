package land.sungbin.androidplayground

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.DrawModifier
import androidx.compose.ui.graphics.drawscope.ContentDrawScope

private object InvisibleModifier : DrawModifier {
    override fun ContentDrawScope.draw() {}
}

// Standard Modifier
fun Modifier.invisible(isHide: Boolean) = when (isHide) {
    true -> then(InvisibleModifier)
    else -> this
}

// Composed Modifier
inline fun Modifier.noRippleClickable(crossinline onClick: () -> Unit): Modifier = composed {
    clickable(
        indication = null,
        interactionSource = remember { MutableInteractionSource() },
        onClick = { onClick() }
    )
}