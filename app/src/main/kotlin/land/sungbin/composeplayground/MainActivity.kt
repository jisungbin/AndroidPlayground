package land.sungbin.composeplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
                    println("ChannelFlow: $it\n")
                }
            }
        }

        setContent {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                SliderWithLabel(
                    value = 10f,
                    valueRange = 1f..100f,
                    finiteEnd = false,
                    onValueChanged = { value ->
                        println(value)
                    }
                )
            }
        }
    }
}
