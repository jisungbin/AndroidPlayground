package land.sungbin.composeplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    private val vm: TestViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lifecycleScope.launchWhenCreated {
            launch {
                vm.sharedFlow.collect {
                    println("SharedFlow: $it")
                }
            }
            launch {
                vm.channelFlow.collect {
                    println("ChannelFlow: $it")
                }
            }
        }

        setContent {
            Text(
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize()
                    .background(color = Color.Blue),
                text = stringResource(R.string.app_name),
                style = LocalTextStyle.current.copy(
                    fontSize = 20.sp,
                    color = Color.White
                )
            )
        }
    }
}
