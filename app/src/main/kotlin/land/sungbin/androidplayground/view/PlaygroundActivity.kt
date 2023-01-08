@file:NoLiveLiterals

package land.sungbin.androidplayground.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Icon
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.NoLiveLiterals
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

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
                CustomTextField(
                    text = text,
                    onTextChanged = { text = it },
                )
            }
        }
    }

    @Composable
    private fun CustomTextField(
        text: String,
        onTextChanged: (String) -> Unit,
    ) {
        BasicTextField(
            value = text,
            onValueChange = onTextChanged,
            textStyle = LocalTextStyle.current.copy(fontSize = 25.sp),
            decorationBox = { innerTextField ->
                Column(
                    modifier = Modifier.drawWithContent {
                        drawContent()
                        drawLine(
                            color = Color(0xFFEFEFEF),
                            start = Offset(
                                x = 0f,
                                y = size.height - 1.dp.toPx(),
                            ),
                            end = Offset(
                                x = size.width,
                                y = size.height - 1.dp.toPx(),
                            ),
                            strokeWidth = 1.dp.toPx(),
                        )
                    },
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(12.dp),
                    ) {
                        Icon(
                            modifier = Modifier.size(24.dp),
                            imageVector = Icons.Default.Search,
                            contentDescription = null,
                            tint = Color(0xFFA8A8A8),
                        )
                        innerTextField()
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                }
            },
        )
    }
}
