package land.sungbin.androidplayground

import android.graphics.Matrix
import android.graphics.Paint
import androidx.compose.runtime.Stable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.asAndroidPath
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlin.math.roundToInt

@Stable
fun Modifier.dropShadow(
  shape: Shape,
  spreadRadius: Dp = 3.dp,
  blurRadius: Dp = spreadRadius,
  color: Color = Color.DarkGray.copy(alpha = 0.1f),
) = drawBehind {
  val outline = shape.createOutline(size, layoutDirection, this)
  require(outline is Outline.Generic) { "Only Outline.Generic is supported" }

  drawIntoCanvas { canvas ->
    val paint = Paint().apply {
      this.color = android.graphics.Color.BLACK

//      if (blurRadius != 0.dp) {
//        maskFilter = BlurMaskFilter(blurRadius.toPx(), BlurMaskFilter.Blur.NORMAL)
//      }

      this.strokeWidth = 30f
    }

    val sx = 1.1f
    val sy = 1.2f

    val matrix = Matrix()
    matrix.setScale(sx, sy)
    val scaledPath = outline.path.asAndroidPath().apply { transform(matrix) }

    val leftOffset = Alignment.CenterHorizontally
      .align(
        size = size.width.roundToInt(),
        space = (size.width * sx).roundToInt(),
        layoutDirection = layoutDirection,
      )
      .toFloat()
    val topOffset = Alignment.CenterVertically
      .align(size = size.height.roundToInt(), space = (size * scale).height.roundToInt())
      .toFloat()

    canvas.translate(-leftOffset, -topOffset)
    canvas.nativeCanvas.drawPath(scaledPath, paint)
    canvas.translate(leftOffset, topOffset)
  }
}
