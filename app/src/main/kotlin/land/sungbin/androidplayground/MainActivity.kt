@file:Suppress("SetTextI18n", "unused", "OPT_IN_IS_NOT_ENABLED", "SameParameterValue")

package land.sungbin.androidplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.currentRecomposeScope
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import land.sungbin.androidplayground.databinding.ActivityMainBinding

class IntHolder {
    var value = 0
        set(value) {
            println("Set: $value")
            field = value
        }
}

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
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center,
            ) {
                Test()
            }
        }
    }

    private fun updateState() {
        binding.tvLabel.text = "State: $state"
    }

    @Composable
    private fun Test() {
        val recomposeScope = currentRecomposeScope
        SideEffect {
            println("Recomposed Test")
        }
        Box(modifier = Modifier.clickable { recomposeScope.invalidate(); println("Invalidate!") })
    }

    @Composable
    private fun LoggingButton(
        modifier: Modifier = Modifier,
        onClick: () -> Unit,
        content: @Composable RowScope.() -> Unit,
    ) {
        SideEffect {
            println("Recomposed Button")
        }
        Button(
            modifier = modifier,
            onClick = onClick,
            content = content
        )
    }

    @Composable
    private fun LoggingText(
        modifier: Modifier = Modifier,
        text: String,
    ) {
        SideEffect {
            println("Recomposed Text")
        }
        Text(
            modifier = modifier,
            text = text
        )
    }
}
