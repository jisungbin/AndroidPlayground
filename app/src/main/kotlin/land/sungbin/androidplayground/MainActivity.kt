@file:Suppress("SetTextI18n", "unused", "OPT_IN_IS_NOT_ENABLED", "SameParameterValue")

package land.sungbin.androidplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
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
            var isHideState by remember { mutableStateOf(false) }

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(PaddingValues(16.dp)),
                contentAlignment = Alignment.Center,
            ) {
                Box(
                    modifier = Modifier
                        .size(250.dp)
                        .noRippleClickable { isHideState = !isHideState }
                        .invisible(isHideState)
                        .background(color = Color.Green)
                )
            }
            // TopWithFooterTest()
        }
    }

    private fun updateState() {
        binding.tvLabel.text = "State: $state"
    }
}
