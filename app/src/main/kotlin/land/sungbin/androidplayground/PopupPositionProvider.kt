package land.sungbin.androidplayground

import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.IntRect
import androidx.compose.ui.unit.IntSize

interface PopupPositionProvider {
  fun Density.calculatePosition(
    rootSize: IntSize,
    anchorBounds: IntRect,
    popupContentSize: IntSize,
  ): IntOffset
}
