package land.sungbin.androidplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.input.TextFieldLineLimits
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.math.max

/**
 * 검증 항목: BasicTextField를 min=0, max=remainingWidth로 measure하면
 * 텍스트 intrinsic width에 맞게 shrink되는가?
 *
 * - SHRUNK: width < maxAvailable → Layout에서 prefix 밀착 배치 가능
 * - FILLED: width = maxAvailable → drawWithCache 필요 (현재 방식)
 */
class PlaygroundActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      Column(
        modifier = Modifier
          .fillMaxSize()
          .padding(horizontal = 24.dp, vertical = 56.dp),
      ) {
        BasicText(
          text = "BasicTextField min=0 shrink 검증",
          style = TextStyle(fontSize = 18.sp),
        )

        Spacer(Modifier.height(32.dp))

        PrefixTextField(
          label = "제안: min=0, max=remaining",
          fixedWidth = false,
        )

        Spacer(Modifier.height(32.dp))

        PrefixTextField(
          label = "기준선: min=max=remaining (현재 방식)",
          fixedWidth = true,
        )
      }
    }
  }
}

private val textStyle = TextStyle(fontSize = 18.sp)

@Composable
private fun PrefixTextField(label: String, fixedWidth: Boolean) {
  val state = remember { TextFieldState("1000") }
  var tfMeasuredWidth by remember { mutableIntStateOf(0) }
  var maxAvailable by remember { mutableIntStateOf(0) }

  Column {
    BasicText(text = label, style = TextStyle(fontSize = 13.sp, color = Color.DarkGray))
    Spacer(Modifier.height(6.dp))

    Layout(
      content = {
        // [0] prefix — 초록 배경으로 영역 표시
        BasicText(
          text = "₩",
          style = textStyle,
          modifier = Modifier.background(Color(0x3000CC00)),
        )
        // [1] textField — 파랑 배경으로 영역 표시
        Box(propagateMinConstraints = true) {
          BasicTextField(
            state = state,
            textStyle = textStyle.copy(textAlign = TextAlign.End),
            lineLimits = TextFieldLineLimits.SingleLine,
            modifier = Modifier
              .background(Color(0x300066FF)),
          )
        }
      },
      modifier = Modifier
        .fillMaxWidth()
        .border(width = 1.dp, color = Color.LightGray)
        .padding(horizontal = 12.dp, vertical = 8.dp),
    ) { measurables, constraints ->
      val gapPx = 4.dp.roundToPx()
      val prefix = measurables[0].measure(constraints.copy(minWidth = 0, minHeight = 0))
      val remaining = max(0, constraints.maxWidth - prefix.width - gapPx)
      maxAvailable = remaining

      val tf = measurables[1].measure(
        if (fixedWidth) constraints.copy(minWidth = remaining, maxWidth = remaining, minHeight = 0)
        else constraints.copy(minWidth = 0, maxWidth = remaining, minHeight = 0),
      )
      tfMeasuredWidth = tf.width

      val h = maxOf(prefix.height, tf.height)

      layout(constraints.maxWidth, h) {
        if (fixedWidth) {
          // 현재 방식: prefix 왼쪽 고정, textField이 나머지 전체 차지
          prefix.placeRelative(0, (h - prefix.height) / 2)
          tf.placeRelative(prefix.width + gapPx, (h - tf.height) / 2)
        } else {
          // 제안 방식: textField을 오른쪽 끝에, prefix를 그 왼쪽에 밀착
          val tfX = constraints.maxWidth - tf.width
          val pX = tfX - gapPx - prefix.width
          prefix.placeRelative(maxOf(0, pX), (h - prefix.height) / 2)
          tf.placeRelative(tfX, (h - tf.height) / 2)
        }
      }
    }

    Spacer(Modifier.height(4.dp))

    val shrunk = tfMeasuredWidth < maxAvailable
    BasicText(
      text = "measured: ${tfMeasuredWidth}px / max: ${maxAvailable}px → ${if (shrunk) "SHRUNK ✓" else "FILLED MAX"}",
      style = TextStyle(
        fontSize = 11.sp,
        color = if (shrunk) Color(0xFF008800) else Color(0xFF880000),
      ),
    )
  }
}
