package land.sungbin.androidplayground

import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.IntRect
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.window.PopupPositionProvider

object DebugPopupPositionProvider : PopupPositionProvider {
  override fun calculatePosition(
    anchorBounds: IntRect,
    windowSize: IntSize,
    layoutDirection: LayoutDirection,
    popupContentSize: IntSize,
  ): IntOffset {
    var candidateX: Int
    var candidateY: Int

    candidateX = (anchorBounds.left - popupContentSize.width / 2).coerceAtLeast(0)
    if (candidateX + popupContentSize.width > windowSize.width) {
      candidateX = (windowSize.width - popupContentSize.width).coerceAtLeast(0)
    }

    candidateY = (anchorBounds.top - popupContentSize.height).coerceAtLeast(0)
    if (candidateY + popupContentSize.height > windowSize.height) {
      candidateY = (windowSize.height - popupContentSize.height).coerceAtLeast(0)
    }

    return IntOffset(x = candidateX, y = candidateY)
  }
}
