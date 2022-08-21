@file:Suppress("MayBeConstant")

package land.sungbin.androidplayground.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onPlaced
import androidx.compose.ui.unit.dp

@Composable
fun Main() {
    Column(modifier = Modifier.size(500.dp)) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .onPlaced {
                    it.size
                    it.size.height
                }
        ) {

        }
    }
}