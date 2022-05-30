package land.sungbin.androidplayground.test

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.core.graphics.blue
import androidx.core.graphics.green
import androidx.core.graphics.red

private typealias NativeColor = android.graphics.Color

@Composable
fun LazyListKeyTest() {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(vertical = 30.dp),
        verticalArrangement = Arrangement.spacedBy(30.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(
            count = 50,
            key = { number -> number }
        ) { number ->
            Text(text = "내 번호: $number")
        }
    }
}

@Composable
fun ColumnSpacedByTest() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(30.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        List(50) { it }.forEach { number ->
            Text(
                modifier = Modifier
                    .border(
                        width = 1.dp,
                        color = with(NativeColor.parseColor("#FF9CFF")) {
                            Color(
                                red = red,
                                green = green,
                                blue = blue
                            )
                        }
                    ),
                text = "내 번호: $number"
            )
        }
    }
}

@Composable
private fun DummyLazyListWithoutKey() {

    LazyColumn {
        items(count = 50) { number ->
            Text(
                modifier = Modifier.padding(vertical = 30.dp),
                text = "내 번호: $number"
            )
        }
    }
}

@Composable
private fun DummyLazyListWithKey() {

    LazyColumn {
        items(
            count = 50,
            key = { number -> number }
        ) { number ->
            Text(
                modifier = Modifier.padding(vertical = 30.dp),
                text = "내 번호: $number"
            )
        }
    }
}

@Composable
private fun DummyLazyListSpacedBy() {

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(30.dp),
    ) {
        items(
            count = 50,
            key = { number -> number }
        ) { number ->
            Text(text = "내 번호: $number")
        }
    }
}

@Composable
private fun DummyColumnSpacedBy() {

    Column(
        verticalArrangement = Arrangement.spacedBy(
            space = 30.dp,
            alignment = Alignment.CenterVertically
        ),
    ) {
        repeat(50) { number ->
            Text(text = "내 번호: $number")
        }
    }
}

@Composable
private fun DummyLazyListContentPadding() {

    LazyColumn(
        contentPadding = PaddingValues(vertical = 30.dp),
        verticalArrangement = Arrangement.spacedBy(30.dp)
    ) {
        items(
            count = 50,
            key = { number -> number }
        ) { number ->
            Text(text = "내 번호: $number")
        }
    }

}
