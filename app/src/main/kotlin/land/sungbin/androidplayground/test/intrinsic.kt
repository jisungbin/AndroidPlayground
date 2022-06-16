@file:OptIn(ExperimentalMaterial3Api::class)
@file:NoLiveLiterals

package land.sungbin.androidplayground.test

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.NoLiveLiterals
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val awesomeTexts = listOf("성빈랜드", "찰스의 안드로이드", "android developer")

@Composable
fun MenuColumnTest() {
    Card(
        modifier = Modifier.width(IntrinsicSize.Max),
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp)
    ) {
        ProvideTextStyle(LocalTextStyle.current.copy(fontSize = 20.sp)) {
            Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
                awesomeTexts.forEach { text ->
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = text,
                    )
                }
            }
        }
    }
}

@Composable
private fun DummyMenuColumnWithMax() {
    Column(Modifier.width(IntrinsicSize.Max)) {
        awesomeTexts.forEach { text ->
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = text
            )
        }
    }
}

@Composable
private fun DummyMenuColumnWithMin() {
    Column(Modifier.width(IntrinsicSize.Min)) {
        awesomeTexts.forEach { text ->
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = text
            )
        }
    }
}
