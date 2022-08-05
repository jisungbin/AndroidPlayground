@file:Suppress(
    "UNUSED_PARAMETER",
    "FunctionName",
    "UNUSED_VARIABLE"
)

package land.sungbin.androidplayground.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import kotlinx.coroutines.Dispatchers

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Dispatchers.Main.immediate
    }
}
