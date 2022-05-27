@file:Suppress("SetTextI18n", "unused", "OPT_IN_IS_NOT_ENABLED", "SameParameterValue")

package land.sungbin.androidplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import land.sungbin.androidplayground.databinding.ActivityMainBinding

class MainActivity : ComponentActivity() {

    private var state by mutableStateOf(1)
    private lateinit var binding: ActivityMainBinding
    private val vm: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /*binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        vm.collect { value, type ->
            println("Collected $value from $type")
        }

        updateState()
        binding.btnTest.setOnClickListener {
            vm.emit(state++)
            updateState()
        }*/

        setContent {
            /*Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(PaddingValues(16.dp)),
                contentAlignment = Alignment.Center,
            ) {
                ClickableTextTest()
            }*/
            TopWithFooterTest()
        }
    }

    private fun updateState() {
        binding.tvLabel.text = "State: $state"
    }
}
