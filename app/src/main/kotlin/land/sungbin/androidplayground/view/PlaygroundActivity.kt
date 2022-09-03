@file:Suppress("MayBeConstant")
@file:NoLiveLiterals

package land.sungbin.androidplayground.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.runtime.NoLiveLiterals
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onPlaced

class PlaygroundActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .onPlaced {
                        println("onPlaced: ${it.size}")
                    },
                value = "Hello",
                onValueChange = { },
                onTextLayout = {
                    println("onTextLayout: ${it.size}")
                },
            )
        }
    }
}