package land.sungbin.androidplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.RoundRect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.geometry.toRect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathOperation
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.drawText
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import kotlin.math.roundToInt

class PlaygroundActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      val density = LocalDensity.current
      val textMeasurer = rememberTextMeasurer(cacheSize = 1)
      val remainingTextLayout = remember(textMeasurer) {
        textMeasurer.measure(
          text = "10회\n사용 가능",
          style = TextStyle.Default.copy(textAlign = TextAlign.Center),
        )
      }
      val ticket = remember {
        RoundedTicketShape(
          cornerRadius = with(density) { 15.dp.toPx() }.let { CornerRadius(it, it) },
          remainingTextLayoutSize = remainingTextLayout.size,
          punchholeRadius = 10.dp,
        )
      }

      Box(
        modifier = Modifier
          .fillMaxSize()
          .padding(all = 30.dp),
        contentAlignment = Alignment.Center,
      ) {
        Box(
          Modifier
            .fillMaxWidth()
            .height(100.dp)
            .dropShadow(shape = ticket, spreadRadius = 15.dp)
            .background(color = Color.White, shape = ticket)
            .clip(ticket)
            .drawWithCache {
              val remainingTextZone = Rect(
                topLeft = Offset(
                  x = size.width - remainingTextLayout.size.width - 30.dp.toPx() * 2,
                  y = 0f,
                ),
                bottomRight = Offset(x = size.width, y = size.height),
              )

              onDrawBehind {
                translate(left = remainingTextZone.left) {
                  drawText(
                    textLayoutResult = remainingTextLayout,
                    color = Color.Blue,
                    topLeft = Offset(
                      x = Alignment.CenterHorizontally
                        .align(
                          size = remainingTextLayout.size.width,
                          space = remainingTextZone.width.roundToInt(),
                          layoutDirection = layoutDirection,
                        )
                        .toFloat(),
                      y = Alignment.CenterVertically
                        .align(size = remainingTextLayout.size.height, space = size.height.roundToInt())
                        .toFloat(),
                    ),
                  )
                }
              }
            }
        )
      }
    }
  }
}

/**
 * @param cornerRadius 모든 모서리에 적용될 둥글기
 * @param remainingTextLayoutSize 티켓 사용 가능 횟수(n회 사용 가능) 텍스트 레이아웃
 * @param punchholeRadius 티켓 절취선 라인에 생성되는 punch hole의 반지름
 */
class RoundedTicketShape(
  private val cornerRadius: CornerRadius,
  private val remainingTextLayoutSize: IntSize,
  private val punchholeRadius: Dp,
) : Shape {
  override fun createOutline(
    size: Size,
    layoutDirection: LayoutDirection,
    density: Density,
  ) = Outline.Generic(
    Path.combine(
      path1 = Path().apply {
        addRoundRect(RoundRect(rect = size.toRect(), cornerRadius = cornerRadius))
      },
      path2 = TicketShape(
        size = size,
        density = density,
        remainingTextLayoutSize = remainingTextLayoutSize,
        punchholeRadius = punchholeRadius,
      ),
      operation = PathOperation.Intersect,
    ),
  )

  @Suppress("FunctionName")
  private fun TicketShape(
    size: Size,
    density: Density,
    remainingTextLayoutSize: IntSize,
    punchholeRadius: Dp,
  ) = Path().apply {
    @Suppress("NAME_SHADOWING")
    val punchholeRadius = with(density) { punchholeRadius.toPx() }
    val punchholeXCenter = with(density) {
      size.width - remainingTextLayoutSize.width - 30.dp.toPx() * 2
    }

    moveTo(x = 0f, y = 0f)
    lineTo(x = punchholeXCenter - punchholeRadius, y = 0f)
    arcTo(
      rect = Rect(
        center = Offset(x = punchholeXCenter, y = 0f),
        radius = punchholeRadius,
      ),
      startAngleDegrees = 180f,
      sweepAngleDegrees = -180f,
      forceMoveTo = false,
    )
    lineTo(x = size.width, y = 0f)
    lineTo(x = size.width, y = size.height)
    lineTo(x = punchholeXCenter - punchholeRadius, y = size.height)
    arcTo(
      rect = Rect(
        center = Offset(x = punchholeXCenter, y = size.height),
        radius = punchholeRadius,
      ),
      startAngleDegrees = 0f,
      sweepAngleDegrees = -180f,
      forceMoveTo = false,
    )
    lineTo(x = 0f, y = size.height)
    close()
  }
}
