package land.sungbin.androidplayground.extension

import androidx.compose.foundation.shape.CornerSize
import androidx.compose.ui.platform.InspectableValue

fun CornerSize.toPercent() = ((this as InspectableValue).valueOverride as String)
    .replace("\"", "")
    .replace("%", "")
    .toFloat()
