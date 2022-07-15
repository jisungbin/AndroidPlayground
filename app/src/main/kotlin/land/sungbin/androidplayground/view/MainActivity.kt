@file:NoLiveLiterals

package land.sungbin.androidplayground.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.NoLiveLiterals
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            var isRow by remember { mutableStateOf(true) }
            val systemUiController = rememberSystemUiController()

            /*val content = remember {
                movableContentOf {
                    repeat(2) {
                        Box(
                            modifier = Modifier
                                .size(100.dp)
                                .background(color = Color.Green)
                        ).also { println("box recomposition") }
                    }
                }
            }*/

            val content = remember<@Composable () -> Unit> {
                {
                    repeat(2) {
                        Box(
                            modifier = Modifier
                                .size(100.dp)
                                .background(color = Color.Green)
                        ).also { println("box recomposition") }
                    }
                }
            }

            LaunchedEffect(Unit) {
                systemUiController.setSystemBarsColor(Color.White)
            }

            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceAround
            ) {
                Button(onClick = { isRow = !isRow }) {
                    Text(text = "Switch")
                }
                if (isRow) {
                    Row(
                        modifier = Modifier.wrapContentSize(),
                        horizontalArrangement = Arrangement.spacedBy(
                            space = 30.dp,
                            alignment = Alignment.CenterHorizontally
                        )
                    ) {
                        content()
                    }
                } else {
                    Column(
                        modifier = Modifier.wrapContentSize(),
                        verticalArrangement = Arrangement.spacedBy(
                            space = 30.dp,
                            alignment = Alignment.CenterVertically
                        )
                    ) {
                        content()
                    }
                }
            }
        }
    }
}


