package land.sungbin.androidplayground

import androidx.compose.ui.geometry.Size
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.IntRect
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.util.fastJoinToString
import kotlin.math.roundToInt

internal data class DebugUiCache(
  val size: Size,
  val anchorBounds: IntRect,
  val title: TextLayoutResult?,
  val contents: List<TextLayoutResult>,
  val source: DebugData,
) {
  init {
    require(contents.isNotEmpty()) { "Expected 'contents' to be non-empty, but it is" }
  }

  private var positionInRoot: IntOffset? = null
  fun positionInRoot(rootSize: IntSize, density: Density): IntOffset {
    if (positionInRoot == null) {
      positionInRoot = with(DebugViewOptions.positionProvider) {
        density.calculatePosition(
          rootSize = rootSize,
          anchorBounds = anchorBounds,
          popupContentSize = IntSize(size.width.roundToInt(), size.height.roundToInt()),
        )
      }
    }
    return positionInRoot!!
  }

  override fun toString() =
    "UiCache(" +
      "size=$size, " +
      "anchorBounds=$anchorBounds, " +
      "title=${title?.layoutInput?.text}," +
      "contets=${contents.fastJoinToString { it.layoutInput.text }}" +
      ")"
}
