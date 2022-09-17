@file:Suppress("MayBeConstant")
@file:NoLiveLiterals

package land.sungbin.androidplayground.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.compose.runtime.NoLiveLiterals
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.delay
import land.sungbin.androidplayground.R

class PlaygroundActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        lifecycleScope.launchWhenCreated {
            println(getDelayedValue(1000, 1))
        }
    }

    private suspend fun <T> getDelayedValue(
        delay: Long,
        value: T,
    ): T {
        delay(delay)
        return value
    }
}