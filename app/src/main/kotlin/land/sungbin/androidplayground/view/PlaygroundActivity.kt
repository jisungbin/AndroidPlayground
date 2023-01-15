@file:NoLiveLiterals

package land.sungbin.androidplayground.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.NoLiveLiterals
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import land.sungbin.androidplayground.mutableStatePairOf

class PlaygroundActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MutableStateWithPairExample()
        }
    }
}

@Composable
fun MutableStatePairExample() {
    val pair = remember { mutableStatePairOf(0 to 0) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(
            space = 15.dp,
            alignment = Alignment.CenterVertically,
        ),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Button(onClick = { pair.firstValue++ }) {
                Text("Increase firstValue")
            }
            Button(onClick = { pair.secondValue++ }) {
                Text("Increase secondValue")
            }
        }
        Text("pair: ${pair.value}")
    }
}

@Composable
fun MutableStateWithPairExample() {
    var pair by remember { mutableStateOf(0 to 0) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(
            space = 15.dp,
            alignment = Alignment.CenterVertically,
        ),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Button(onClick = { pair = pair.copy(first = pair.first + 1) }) {
                Text("Increase firstValue")
            }
            Button(onClick = { pair = pair.copy(second = pair.second + 1) }) {
                Text("Increase secondValue")
            }
        }
        Text("pair: $pair")
    }
}