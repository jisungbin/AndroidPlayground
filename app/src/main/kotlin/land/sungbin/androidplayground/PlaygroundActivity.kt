@file:NoLiveLiterals

package land.sungbin.androidplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.NoLiveLiterals
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.Measurable
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.dp

class PlaygroundActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Layout(
                modifier = Modifier.fillMaxSize(),
                content = {
                    Box(
                        modifier = Modifier
                            .layoutId("green")
                            .size(100.dp)
                            .background(color = Color.Green)
                    )
                    Box(
                        modifier = Modifier
                            .layoutId("red")
                            .size(100.dp)
                            .background(color = Color.Red)
                    )
                    Box(
                        modifier = Modifier
                            .layoutId("blue")
                            .size(100.dp)
                            .background(color = Color.Blue)
                    )
                },
                measurePolicy = { measurables: List<Measurable>, constraints: Constraints ->
                    val looseConstaints = constraints.copy(
                        minHeight = 150.dp.roundToPx(),
                        minWidth = 100.dp.roundToPx(),
                    )

                    val blueMeasurable = measurables.find { it.layoutId == "blue" }!!
                    val greenMeasurable = measurables.find { it.layoutId == "green" }!!
                    val redMeasurable = measurables.find { it.layoutId == "red" }!!

                    val bluePlaceable = blueMeasurable.measure(looseConstaints)
                    val redPlaceable = redMeasurable.measure(looseConstaints)
                    val greenPlaceable = greenMeasurable.measure(looseConstaints)

                    layout(width = constraints.minWidth, height = constraints.minHeight) {
                        val y = 100
                        bluePlaceable.place(x = 100, y = y)
                        redPlaceable.place(x = 100, y = y + bluePlaceable.height)
                        greenPlaceable.place(x = 100, y = y + bluePlaceable.height + redPlaceable.height)
                    }
                },
            )
        }
    }
}
