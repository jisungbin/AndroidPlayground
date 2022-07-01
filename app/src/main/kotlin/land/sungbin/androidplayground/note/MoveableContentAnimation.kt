@file:Suppress(
    "unused",
    "FunctionName"
)

package land.sungbin.androidplayground.note

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.runtime.movableContentOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import land.sungbin.androidplayground.theme.Random

// DO NOT WORKING.
// Source by: https://developer.android.com/reference/kotlin/androidx/compose/runtime/package-summary#movableContentOf(kotlin.Function0)
@Composable
fun MovableContentAnimation() {
    val colors = List(50) { Color.Random }
    val colorMap = remember {
        mutableMapOf<Color, @Composable () -> Unit>()
    }
    val movableItems = colors.map { color ->
        colorMap.getOrPut(color) {
            movableContentOf {
                Box(
                    modifier = Modifier
                        .size(100.dp)
                        .background(color = color)
                )
            }
        }
    }

    val itemsPerColumn = 10
    val columns = colors.size / itemsPerColumn + (if (colors.size % itemsPerColumn == 0) 0 else 1)
    Row(modifier = Modifier.fillMaxSize()) {
        repeat(columns) { column ->
            Column(modifier = Modifier.fillMaxWidth().wrapContentHeight()) {
                val base = column * itemsPerColumn
                val end = minOf(base + itemsPerColumn, colors.size)
                for (index in base until end) {
                    movableItems[index]()
                }
            }
        }
    }
}
