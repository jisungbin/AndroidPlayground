@file:Suppress("MayBeConstant", "UNUSED_ANONYMOUS_PARAMETER")
@file:NoLiveLiterals
@file:OptIn(ExperimentalAnimationApi::class)

package land.sungbin.androidplayground.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.NoLiveLiterals
import androidx.compose.runtime.NonRestartableComposable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.layout
import androidx.compose.ui.unit.IntOffset

class PlaygroundActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center,
            ) {
                Counter()
            }
        }
    }
}

@Composable
fun Main() {
    Modifier.offset { IntOffset(x = 0, y = 0) }
    Modifier.layout { measurable, constraints ->
        val placeable = measurable.measure(constraints)
        layout(width = 0, height = 0) {
            placeable.place(x = 0, y = 0, zIndex = 1f)
        }
    }
    Modifier.graphicsLayer {
        scaleX = 1f; rotationX = 0f; clip = false
        shape = RectangleShape; translationX = 0f
        alpha = 1f; shadowElevation = 0f
    }
}

fun getOne() = 1

@Composable
@NonRestartableComposable
fun DelegateOtherComposable() {
    Counter()
}

@Composable
// @NonRestartableComposable
@androidx.compose.runtime.ExplicitGroupsComposable
fun Counter() {
    var number by remember { mutableStateOf(1) }
    Button(onClick = { number++ }) {
        Text(text = number.toString())
    }
}
