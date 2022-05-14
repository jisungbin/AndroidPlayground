@file:Suppress("SetTextI18n", "unused", "OPT_IN_IS_NOT_ENABLED")

package land.sungbin.androidplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RecompositionGenerator()
        }
    }

    @Composable
    private fun RecompositionGenerator() {
        SideEffect {
            println("Composition: RecompositionGenerator function")
        }

        var number by remember { mutableStateOf(0) }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .clickable { number++ },
            contentAlignment = Alignment.Center
        ) {
            SideEffect {
                println("Composition: Box Scope")
            }
            Text(text = number.toString())
        }
    }
}
