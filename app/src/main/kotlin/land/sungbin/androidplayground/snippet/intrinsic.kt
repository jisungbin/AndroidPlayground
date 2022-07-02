@file:OptIn(
    ExperimentalMaterial3Api::class,
    ExperimentalMaterial3Api::class
)
@file:Suppress("SpellCheckingInspection")

package land.sungbin.androidplayground.snippet

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.Text
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import land.sungbin.androidplayground.composable.SortedColumn

private val messages = listOf("naver", "sungbinland", "androiddeveloper")

@Preview
@Composable
fun IntrinsicPreview() {
    SortedColumn(space = 50.dp) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "IntrinsicSize.Max",
                style = LocalTextStyle.current.copy(fontSize = 20.sp)
            )
            Spacer(modifier = Modifier.height(20.dp))
            Card(
                modifier = Modifier.width(IntrinsicSize.Max),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
            ) {
                Column(verticalArrangement = Arrangement.spacedBy(15.dp)) {
                    messages.forEach { message ->
                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            text = message,
                        )
                    }
                }
            }
        }

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "IntrinsicSize.Min",
                style = LocalTextStyle.current.copy(fontSize = 20.sp)
            )
            Spacer(modifier = Modifier.height(20.dp))
            Card(
                modifier = Modifier.width(IntrinsicSize.Min),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
            ) {
                Column(verticalArrangement = Arrangement.spacedBy(15.dp)) {
                    messages.forEach { message ->
                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            text = message,
                        )
                    }
                }
            }
        }
    }
}
