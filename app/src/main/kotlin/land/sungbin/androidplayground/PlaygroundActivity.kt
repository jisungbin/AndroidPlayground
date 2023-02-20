@file:NoLiveLiterals

package land.sungbin.androidplayground

import androidx.activity.ComponentActivity
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalMinimumInteractiveComponentEnforcement
import androidx.compose.runtime.Composable
import javax.script.ScriptEngineManager
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.NoLiveLiterals

class PlaygroundActivity : ComponentActivity()

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Main() {
    CompositionLocalProvider(
        // androidx.compose.material3.LocalMinimumInteractiveComponentEnforcement
        LocalMinimumInteractiveComponentEnforcement provides false,
    ) {

    }
}
