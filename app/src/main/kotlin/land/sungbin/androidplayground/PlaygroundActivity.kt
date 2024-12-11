@file:Suppress("INVISIBLE_REFERENCE", "INVISIBLE_MEMBER")

package land.sungbin.androidplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.snapping.SnapPosition
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.material.RadioButton
import androidx.compose.material.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontVariation
import androidx.compose.ui.text.font.FontVariation.slant
import androidx.compose.ui.text.font.FontVariation.weight
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.util.fastFlatMap
import androidx.compose.ui.util.fastForEach
import androidx.compose.ui.util.fastMap

class PlaygroundActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      val fonts = remember { pretendardVariables() }
      val fontFamily = remember(fonts) { FontFamily(fonts) }

      var selectedFontWeight by remember { mutableStateOf(fonts.first().weight) }
      var selectedFontStyle by remember { mutableStateOf(fonts.first().style) }
      var selectedTextDecoration by remember { mutableStateOf(TextDecoration.None) }

      val inputs = remember { TextFieldState("Hello, World!, 안녕, 세상!, こんにちは、世界!") }

      Column(
        modifier = Modifier
          .fillMaxSize()
          .background(color = Color.White),
      ) {
        BasicTextField(
          inputs,
          modifier = Modifier
            .weight(1f)
            .fillMaxWidth()
            .padding(all = 30.dp)
            .wrapContentHeight(),
          textStyle = TextStyle(
            color = Color.Black,
            fontSize = 20.sp,
            fontWeight = selectedFontWeight,
            fontStyle = selectedFontStyle,
            fontFamily = fontFamily,
            textDecoration = selectedTextDecoration,
            textAlign = TextAlign.Center,
          ),
        )
        Column(
          modifier = Modifier
            .fillMaxWidth()
            .padding(start = 30.dp, bottom = 30.dp),
          verticalArrangement = Arrangement.spacedBy(15.dp),
        ) {
          val fontWeights = remember(fonts) { fonts.fastMap(Font::weight).distinct() }
          val fontStyles = remember(fonts) { fonts.fastMap(Font::style).distinct() }
          val textDecorations = remember { listOf(TextDecoration.None, TextDecoration.Underline, TextDecoration.LineThrough) }

          Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(15.dp),
            verticalAlignment = Alignment.CenterVertically,
          ) {
            Text("Weight", fontWeight = FontWeight.ExtraBold)
            LazyRow(
              modifier = Modifier.fillMaxWidth(),
              contentPadding = PaddingValues(start = 15.dp, end = 30.dp),
              horizontalArrangement = Arrangement.spacedBy(6.dp),
            ) {
              items(fontWeights) { weight ->
                Column(
                  horizontalAlignment = Alignment.CenterHorizontally,
                  verticalArrangement = Arrangement.spacedBy(2.dp, alignment = Alignment.CenterVertically),
                ) {
                  RadioButton(
                    selected = weight == selectedFontWeight,
                    onClick = { selectedFontWeight = weight },
                  )
                  Text(weight.weight.toString())
                }
              }
            }
          }

          Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(15.dp),
            verticalAlignment = Alignment.CenterVertically,
          ) {
            Text("Style", fontWeight = FontWeight.ExtraBold)
            Row(
              modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp),
              horizontalArrangement = Arrangement.spacedBy(6.dp),
            ) {
              fontStyles.fastForEach { style ->
                Column(
                  horizontalAlignment = Alignment.CenterHorizontally,
                  verticalArrangement = Arrangement.spacedBy(2.dp, alignment = Alignment.CenterVertically),
                ) {
                  RadioButton(
                    selected = style == selectedFontStyle,
                    onClick = { selectedFontStyle = style },
                  )
                  Text(style.value.toString())
                }
              }
            }
          }

          Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(15.dp),
            verticalAlignment = Alignment.CenterVertically,
          ) {
            Text("Decoration", fontWeight = FontWeight.ExtraBold)
            Row(
              modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp),
              horizontalArrangement = Arrangement.spacedBy(6.dp),
            ) {
              textDecorations.fastForEach { decoration ->
                Column(
                  horizontalAlignment = Alignment.CenterHorizontally,
                  verticalArrangement = Arrangement.spacedBy(2.dp, alignment = Alignment.CenterVertically),
                ) {
                  RadioButton(
                    selected = decoration == selectedTextDecoration,
                    onClick = { selectedTextDecoration = decoration },
                  )
                  Text(decoration.toString().substringAfter('.'))
                }
              }
            }
          }
        }
      }
    }
  }
}

@OptIn(ExperimentalTextApi::class)
private fun pretendardVariables(): List<Font> =
  FontWeight.values
    .fastFlatMap { weight -> FontStyle.values().fastMap { style -> weight to style } }
    .fastMap { (weight, style) ->
      Font(
        R.font.pretendard_jp_variable,
        weight = weight,
        style = style,
        variationSettings = FontVariation.Settings(weight, style),
      )
    }
