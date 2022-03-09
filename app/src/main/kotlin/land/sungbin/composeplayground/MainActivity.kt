package land.sungbin.composeplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Text(
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize()
                    .background(color = Color.Blue),
                text = stringResource(R.string.app_name),
                style = LocalTextStyle.current.copy(
                    fontSize = 20.sp,
                    color = Color.Cyan
                )
            )
        }
    }
}
