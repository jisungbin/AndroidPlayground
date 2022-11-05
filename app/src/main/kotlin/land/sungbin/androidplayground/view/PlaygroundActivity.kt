@file:Suppress("MayBeConstant", "UNUSED_ANONYMOUS_PARAMETER", "UNUSED_VARIABLE")
@file:NoLiveLiterals
@file:OptIn(ExperimentalAnimationApi::class)

package land.sungbin.androidplayground.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.NoLiveLiterals
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class PlaygroundActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center,
            ) {
                Text(
                    text = "Hello, World!",
                    fontSize = 30.sp,
                )
            }
        }
    }
}

@Composable
fun Main() {
    val density = LocalDensity.current
    val px = with(density) {
        1.dp.toPx()
    }
    val px2 = with(density) {
        2.dp.toPx()
    }
    val px3 = with(density) {
        3.dp.toPx()
    }
    val px4 = with(density) {
        4.dp.toPx()
    }
}

inline val Dp.px
    @Composable
    @ReadOnlyComposable
    get() = with(LocalDensity.current) {
        toPx()
    }
