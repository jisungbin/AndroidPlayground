package land.sungbin.androidplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.recyclerview.widget.RecyclerView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        xml()
    }

    private fun xml() {
        setContentView(R.layout.activity_main)
        findViewById<RecyclerView>(R.id.rv_texts).adapter = TextAdapter(count = 5)
    }

    private fun compose() {
        setContent {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(space = 30.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                repeat(times = 5) {
                    Text(
                        text = stringResource(R.string.sungbin_land),
                        style = TextStyle(
                            fontFamily = FontFamily(Font(R.font.nanumgothic)),
                            fontSize = 30.sp,
                            color = Color.Black
                        )
                    )
                }
            }
        }
    }
}