@file:NoLiveLiterals

package land.sungbin.androidplayground.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.NoLiveLiterals
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

class PlaygroundActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var text by remember { mutableStateOf("") }

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(30.dp),
                contentAlignment = Alignment.Center,
            ) {
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {


                    TextField(
                        modifier = Modifier
                            .width(50.dp)
                            .border(color = Color.Green, width = 1.dp),
                        value = text,
                        onValueChange = { text = it },
                    )
                    BasicTextField(
                        modifier = Modifier
                            .width(50.dp)
                            .border(color = Color.Green, width = 1.dp),
                        value = text,
                        onValueChange = { text = it },
                    )





                }





            }
        }
    }

    @Composable
    private fun CircleStyleTextField(
        text: String,
        onTextChanged: (text: String) -> Unit,
    ) {
        BasicTextField(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .border(color = Color.Green, width = 1.dp),
            value = text,
            onValueChange = onTextChanged,
            decorationBox = {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .horizontalScroll(rememberScrollState()),
                    horizontalArrangement = Arrangement.spacedBy(4.dp),
                ) {
                    text.forEach {
                        CircleText(it)
                    }
                }
            },
        )
    }

    @Composable
    private fun CircleText(text: Char) {
        Box(
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape)
                .border(
                    color = Color.Black,
                    width = 1.dp,
                    shape = CircleShape,
                ),
            contentAlignment = Alignment.Center,
        ) {
            Text(text = text.toString(), color = Color.Black)
        }
    }
}
