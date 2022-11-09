@file:Suppress(
    "MayBeConstant", "UNUSED_ANONYMOUS_PARAMETER", "UNUSED_VARIABLE",
    "KotlinRedundantDiagnosticSuppress", "UnnecessaryOptInAnnotation"
)
@file:NoLiveLiterals
@file:OptIn(ExperimentalAnimationApi::class, ExperimentalMaterialApi::class)

package land.sungbin.androidplayground.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Button
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.NoLiveLiterals
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat

class PlaygroundActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            val (state, setText) = remember {
                mutableStateOf(
                    value = "",
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .systemBarsPadding(),
                verticalArrangement = Arrangement.spacedBy(
                    space = 30.dp,
                    alignment = Alignment.Bottom,
                ),
            ) {
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight(),
                    onClick = { /*TODO*/ },
                ) {
                    Text(
                        text = "Button!",
                    )
                }
                TextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .imePadding(),
                    value = state,
                    onValueChange = setText,
                )
            }
        }
    }
}
