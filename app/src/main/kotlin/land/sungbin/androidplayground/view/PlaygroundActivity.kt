@file:NoLiveLiterals
@file:OptIn(ExperimentalLayoutApi::class)

package land.sungbin.androidplayground.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.ime
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.NoLiveLiterals
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat

class PlaygroundActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)

        setContent {
            val (text, setText) = remember { mutableStateOf("") }
            val imeInsets = WindowInsets.ime
            val navigationBarInsets = WindowInsets.navigationBars

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(WindowInsets.systemBars.asPaddingValues())
                    .padding(16.dp),
                verticalArrangement = Arrangement.SpaceBetween,
            ) {
                Text(
                    text = "Hello, World!",
                    fontSize = 30.sp,
                )
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .offset {
                            val imeHeight = imeInsets.getBottom(this)
                            val nagivationBarHeight = navigationBarInsets.getBottom(this)
                            // ime height 에 navigation height 가 포함되는 것으로 추측됨
                            val yOffset = imeHeight
                                .minus(nagivationBarHeight)
                                .coerceAtLeast(0)
                            IntOffset(x = 0, y = -yOffset)
                        },
                    verticalArrangement = Arrangement.spacedBy(15.dp),
                ) {
                    Button(
                        modifier = Modifier.fillMaxWidth(),
                        onClick = {},
                    ) {
                        Text(text = "Button")
                    }
                    TextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = text,
                        onValueChange = setText,
                    )
                }
            }
        }
    }
}
