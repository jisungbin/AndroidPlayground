@file:NoLiveLiterals

package land.sungbin.androidplayground.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.text.BasicText
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.NoLiveLiterals
import androidx.compose.ui.tooling.preview.Preview

class PlaygroundActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicText(text = "Hello")
        }
    }
}


@Composable
@Preview(
    showSystemUi = true,
    device = "spec:shape=Normal,width=100,height=100,unit=dp,dpi=420"
)
private fun Test() {
    Text(text = "Hello World!")
}

@Composable
@Preview(backgroundColor = 0xFFFFFF, showBackground = true)
private fun Test2() {
    Text(text = "Hello World!2")
}








