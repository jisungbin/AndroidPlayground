@file:Suppress("MayBeConstant")
@file:NoLiveLiterals

package land.sungbin.androidplayground.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.NoLiveLiterals
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration

class NumberHolder {
    var number by mutableStateOf(1)
}

class PlaygroundActivity : ComponentActivity() {
    private var numberHolder = NumberHolder()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        println("Creation Activity.")
        setContent {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .clickable { numberHolder.number++ },
                contentAlignment = Alignment.Center,
            ) {
                Text(
                    text = "Hello, World!" +
                            "orientation is ${LocalConfiguration.current.orientation}, " +
                            "number is ${numberHolder.number}",
                )
            }
        }
    }
}
