@file:NoLiveLiterals

package land.sungbin.androidplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.NoLiveLiterals
import androidx.compose.ui.Modifier

class PlaygroundActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Box(modifier = Modifier, propagateMinConstraints = true) {
                Modifier.matchParentSize()
            }
        }
    }
}
