@file:Suppress(
    "PrivatePropertyName",
    "PropertyName"
)

package land.sungbin.androidplayground.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            var number by remember { mutableStateOf(1) }
            TextWrapper(
                modifier = Modifier.clickable { number++ },
                text = number.toString()
            )
        }
    }
}

@Composable
fun TextWrapper(
    modifier: Modifier = Modifier,
    text: String
) {
    Text(modifier = modifier, text = text)
}