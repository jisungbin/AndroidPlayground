@file:Suppress("MayBeConstant")
@file:NoLiveLiterals

package land.sungbin.androidplayground.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.compose.runtime.NoLiveLiterals
import kotlinx.coroutines.delay
import land.sungbin.androidplayground.R

class SecondActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private suspend fun <T> getDelayedValue(
        delay: Long,
        value: T,
    ): T {
        delay(delay)
        return value
    }
}
