@file:Suppress("MayBeConstant")
@file:NoLiveLiterals
@file:OptIn(ExperimentalAnimationApi::class)

package land.sungbin.androidplayground.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.NoLiveLiterals
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

class PlaygroundActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var isLoading by remember { mutableStateOf(false) }
            println("Recompose setContent")

            Column {
                Text(
                    modifier = Modifier.clickable {
                        isLoading = !isLoading
                    },
                    text = "Column Data",
                ).also { println("Recompose first text") }
                if (isLoading) {
                    Text(text = "Loading...")
                }
            }.also { println("Recompose Column") }
        }
    }
}
