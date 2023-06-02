package aaaa.quackicon

import androidx.compose.ui.graphics.StrokeCap.Companion.Round as strokeCapRound
import androidx.compose.ui.graphics.StrokeJoin.Companion.Round as strokeJoinRound
import aaaa.QuackIcon
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

public val QuackIcon.Explore24Fill: ImageVector
  get() {
    if (_explore24Fill != null) {
      return _explore24Fill!!
    }
    _explore24Fill = Builder(
      name = "Explore24Fill", defaultWidth = 24.0.dp, defaultHeight =
      24.0.dp, viewportWidth = 24.0f, viewportHeight = 24.0f
    ).apply {
      path(
        fill = SolidColor(Color(0xFF222222)), stroke = SolidColor(Color(0xFF222222)),
        strokeLineWidth = 1.5f, strokeLineCap = Butt, strokeLineJoin = Miter,
        strokeLineMiter = 4.0f, pathFillType = NonZero
      ) {
        moveTo(12.0f, 12.0f)
        moveToRelative(-9.0f, 0.0f)
        arcToRelative(9.0f, 9.0f, 0.0f, true, true, 18.0f, 0.0f)
        arcToRelative(9.0f, 9.0f, 0.0f, true, true, -18.0f, 0.0f)
      }
      path(
        fill = SolidColor(Color(0xFFffffff)), stroke = SolidColor(Color(0xFFffffff)),
        strokeLineWidth = 1.5f, strokeLineCap = strokeCapRound, strokeLineJoin =
        strokeJoinRound, strokeLineMiter = 4.0f, pathFillType = NonZero
      ) {
        moveTo(9.8906f, 9.8906f)
        lineTo(14.1094f, 14.1094f)
        lineTo(8.4844f, 15.5156f)
        lineTo(9.8906f, 9.8906f)
        close()
      }
      path(
        fill = SolidColor(Color(0xFFFF8300)), stroke = SolidColor(Color(0xFFFF8300)),
        strokeLineWidth = 1.5f, strokeLineCap = strokeCapRound, strokeLineJoin =
        strokeJoinRound, strokeLineMiter = 4.0f, pathFillType = NonZero
      ) {
        moveTo(14.1089f, 14.1093f)
        lineTo(9.8902f, 9.8906f)
        lineTo(15.5151f, 8.4844f)
        lineTo(14.1089f, 14.1093f)
        close()
      }
    }
      .build()
    return _explore24Fill!!
  }

private var _explore24Fill: ImageVector? = null
