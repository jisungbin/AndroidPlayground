package land.sungbin.androidplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.LinearGradientShader
import androidx.compose.ui.graphics.ShaderBrush
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class PlaygroundActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    enableEdgeToEdge()
    super.onCreate(savedInstanceState)
    setContent {
      val isDarkTheme = isSystemInDarkTheme() // Detect system dark mode
      MaterialTheme {
        GradientTextDemo()
      }
    }
  }
}

@Composable
fun GradientTextDemo() {
  val text = "Build better apps faster with\n" +
    "Jetpack Compose"
  val fontSize = 30.sp
  val colors = listOf(Color(0xFFFC5C7D), Color(0xFF6A82FB)) // Gradient colors for text: #FC5C7D to #6A82FB
  Column(
    modifier = Modifier
      .fillMaxSize()
      .background(MaterialTheme.colors.background) // Explicitly set background to theme's background color
      .padding(16.dp)
      .verticalScroll(rememberScrollState()),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Top
  ) {
    Spacer(Modifier.height(10.dp))
    Text(
      text = "Animating brush Text coloring in Compose",
    )
    // Candy Cane Shimmer
    Text(
      text = text,
      style = TextStyle(
        fontSize = fontSize,
        fontWeight = FontWeight.Bold,
        brush = candyCaneBrush(fontSize, colors)
      )
    )
    Text(
      text = "Candy Cane Shimmer: Diagonal moving gradient for a candy-like effect, feel the smooth animation flow",
      style = TextStyle(fontSize = 14.sp, color = MaterialTheme.colors.onBackground.copy(alpha = 0.6f)) // Adaptive caption color for visibility in dark/light
    )
    Divider(modifier = Modifier.padding(vertical = 16.dp), color = MaterialTheme.colors.onBackground.copy(alpha = 0.3f)) // Adaptive divider color
    // Back and Forth Shimmer
    Text(
      text = text,
      style = TextStyle(
        fontSize = fontSize,
        fontWeight = FontWeight.Bold,
        brush = backAndForthBrush(colors)
      )
    )
    Text(
      text = "Back and Forth Shimmer: Gradient rocks side to side, creating a dynamic waving motion",
      style = TextStyle(fontSize = 14.sp, color = MaterialTheme.colors.onBackground.copy(alpha = 0.6f)) // Adaptive caption color for visibility in dark/light
    )
    Divider(modifier = Modifier.padding(vertical = 16.dp), color = MaterialTheme.colors.onBackground.copy(alpha = 0.3f)) // Adaptive divider color
    // Static Gradient
    Text(
      text = text,
      style = TextStyle(
        fontSize = fontSize,
        fontWeight = FontWeight.Bold,
        brush = Brush.linearGradient(colors)
      )
    )
    Text(
      text = "Static Gradient: Fixed color blend from pink to blue, no animation but vibrant look",
      style = TextStyle(fontSize = 14.sp, color = MaterialTheme.colors.onBackground.copy(alpha = 0.6f)) // Adaptive caption color for visibility in dark/light
    )
    Divider(modifier = Modifier.padding(vertical = 16.dp), color = MaterialTheme.colors.onBackground.copy(alpha = 0.3f)) // Adaptive divider color
    // Partial Gradient
    Text(
      text = buildAnnotatedString {
        withStyle(style = SpanStyle(brush = Brush.linearGradient(colors))) {
          append("Animating brush ")
        }
        append("Text coloring in Compose")
      },
      style = TextStyle(
        fontSize = fontSize,
        fontWeight = FontWeight.Bold
      )
    )
    Text(
      text = "Partial Gradient: Gradient on 'Animating brush' only, highlights key phrase for emphasis",
      style = TextStyle(fontSize = 14.sp, color = MaterialTheme.colors.onBackground.copy(alpha = 0.6f)) // Adaptive caption color for visibility in dark/light
    )
    Divider(modifier = Modifier.padding(vertical = 16.dp), color = MaterialTheme.colors.onBackground.copy(alpha = 0.3f)) // Adaptive divider color
    // Gradient with Opacity
    Text(
      text = text,
      style = TextStyle(
        fontSize = fontSize,
        fontWeight = FontWeight.Bold,
        brush = Brush.linearGradient(colors),
        alpha = 0.5f
      )
    )
    Text(
      text = "Gradient with Opacity: Faded gradient effect, subtle and elegant for softer visuals",
      style = TextStyle(fontSize = 14.sp, color = MaterialTheme.colors.onBackground.copy(alpha = 0.6f)) // Adaptive caption color for visibility in dark/light
    )
  }
}

@Composable
fun candyCaneBrush(fontSize: androidx.compose.ui.unit.TextUnit, colors: List<Color>): Brush {
  val density = LocalDensity.current
  val fontSizePx = with(density) { fontSize.toPx() }
  val infiniteTransition = rememberInfiniteTransition()
  val offset by infiniteTransition.animateFloat(
    initialValue = 0f,
    targetValue = fontSizePx * 2,
    animationSpec = infiniteRepeatable(
      animation = tween(2000),
      repeatMode = RepeatMode.Restart
    )
  )
  return Brush.linearGradient(
    colors = colors,
    start = Offset(0f, 0f),
    end = Offset(offset, offset),
    tileMode = TileMode.Mirror
  )
}

@Composable
fun backAndForthBrush(colors: List<Color>): Brush {
  val infiniteTransition = rememberInfiniteTransition()
  val offset by infiniteTransition.animateFloat(
    initialValue = 0f,
    targetValue = 1f,
    animationSpec = infiniteRepeatable(
      animation = tween(2000),
      repeatMode = RepeatMode.Reverse
    )
  )
  return remember(offset) {
    ShaderBrush(
      LinearGradientShader(
        from = Offset.Zero,
        to = Offset(offset * 1000f, offset * 1000f), // Scaled for drawing area
        colors = colors,
        tileMode = TileMode.Mirror
      )
    )
  }
}
