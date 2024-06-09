package land.sungbin.androidplayground

import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.IntRect
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp

object DebugPopupPositionProvider : PopupPositionProvider {
  override fun Density.calculatePosition(
    rootSize: IntSize,
    anchorBounds: IntRect,
    popupContentSize: IntSize,
  ) = IntOffset(
    x = (rootSize.width - popupContentSize.width - 30.dp.roundToPx()).coerceAtLeast(0),
    y = 30.dp.roundToPx(),
  )
}
