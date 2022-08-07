@file:Suppress("PropertyName", "MemberVisibilityCanBePrivate")
@file:NoLiveLiterals

package land.sungbin.androidplayground.view

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.NoLiveLiterals
import androidx.compose.runtime.Stable
import androidx.compose.ui.Modifier

@Stable
class StableModifierInstance : Modifier.Element

@Stable
private fun Modifier.something1() = this.then(StableModifierInstance())

class Activity {
    @Stable
    private fun Modifier.something2() = this.then(StableModifierInstance())

    @Composable
    fun Content() {
        MyBox {
            Modifier.something1()
        }

        MyBox {
            Modifier.something2()
        }
    }

    @Composable
    fun MyBox(getModifier: () -> Modifier) {
        Box(modifier = getModifier())
    }
}