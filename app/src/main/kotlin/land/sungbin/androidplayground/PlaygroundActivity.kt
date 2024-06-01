package land.sungbin.androidplayground

import android.graphics.BlurMaskFilter
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.RoundRect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.geometry.toRect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.PathOperation
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextLayoutResult
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
      val textMeasurer = rememberTextMeasurer(cacheSize = 1)
      val remainingTextLayout = remember(textMeasurer) {
        textMeasurer.measure(
          text = "10회\n사용 가능",
          style = TextStyle.Default.copy(textAlign = TextAlign.Center),
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
            .roundedTicketShape(
              cornerRadius = 15.dp,
              remainingTextLayout = remainingTextLayout,
              remainingTextLayoutHorizontalPadding = 30.dp,
              punchholeRadius = 10.dp,
            ),
        )
      }
    }
  }
}

private fun Modifier.roundedTicketShape(
  cornerRadius: Dp,
  remainingTextLayout: TextLayoutResult,
  remainingTextLayoutHorizontalPadding: Dp,
  punchholeRadius: Dp,
) = composed {
  val density = LocalDensity.current
  val ticket = remember(cornerRadius, remainingTextLayout, remainingTextLayoutHorizontalPadding, punchholeRadius) {
    RoundedTicketShape(
      cornerRadius = with(density) { cornerRadius.toPx() }.let { CornerRadius(it, it) },
      remainingTextLayoutSize = remainingTextLayout.size,
      remainingTextLayoutHorizontalPadding = remainingTextLayoutHorizontalPadding,
      punchholeRadius = punchholeRadius,
    )
  }

  this
    // .dropShadow(borderRadius = cornerRadius)
    .dropShadow(shape = ticket, blurRadius = 10.dp)
    .clip(ticket)
    .background(color = Color.White, shape = ticket)
    .drawWithCache {
      val punchholeXCenter = run {
        size.width
          .minus(remainingTextLayout.size.width)
          .minus(remainingTextLayoutHorizontalPadding.toPx() * 2)
      }

      val remainingZone = Rect(
        topLeft = Offset(x = punchholeXCenter, y = 0f),
        bottomRight = Offset(x = size.width, y = size.height),
      )
      val remainingZoneLinePadding = 5.dp

      onDrawBehind {
        translate(left = remainingZone.left) {
          drawText(
            textLayoutResult = remainingTextLayout,
            color = Color.Blue,
            topLeft = Offset(
              x = Alignment.CenterHorizontally
                .align(
                  size = remainingTextLayout.size.width,
                  space = remainingZone.width.roundToInt(),
                  layoutDirection = layoutDirection,
                )
                .toFloat(),
              y = Alignment.CenterVertically
                .align(size = remainingTextLayout.size.height, space = size.height.roundToInt())
                .toFloat(),
            ),
          )
          drawLine(
            color = Color.LightGray,
            start = Offset(x = 0f, y = punchholeRadius.toPx() + remainingZoneLinePadding.toPx()),
            end = Offset(x = 0f, y = size.height - (punchholeRadius.toPx() + remainingZoneLinePadding.toPx())),
            strokeWidth = 1.dp.toPx(),
            pathEffect = PathEffect.dashPathEffect(intervals = FloatArray(2) { 2.dp.toPx() }),
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
  private val remainingTextLayoutHorizontalPadding: Dp,
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
        remainingTextLayoutHorizontalPadding = remainingTextLayoutHorizontalPadding,
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
    remainingTextLayoutHorizontalPadding: Dp,
    punchholeRadius: Dp,
  ) = Path().apply {
    @Suppress("NAME_SHADOWING")
    val punchholeRadius = with(density) { punchholeRadius.toPx() }
    val punchholeXCenter = with(density) {
      size.width
        .minus(remainingTextLayoutSize.width)
        .minus(remainingTextLayoutHorizontalPadding.toPx() * 2)
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


@Stable
fun Modifier.dropShadow(
  shape: Shape,
  blurRadius: Dp = 3.dp,
  color: Color = Color.DarkGray.copy(alpha = 0.1f),
) = drawBehind {
  drawIntoCanvas { canvas ->
    val paint = Paint().also { paint ->
      paint.asFrameworkPaint().apply {
        this.color = color.toArgb()

        if (blurRadius != 0.dp) {
          maskFilter = BlurMaskFilter(blurRadius.toPx(), BlurMaskFilter.Blur.OUTER)
        }
      }
    }

    val outline = shape.createOutline(size = size, layoutDirection = layoutDirection, density = this)
    require(outline is Outline.Generic) { "'shape' must be Generic type" }

    canvas.drawPath(outline.path, paint)
  }
}

