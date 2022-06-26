@file:Suppress("RedundantUnitReturnType", "unused")
@file:NoLiveLiterals

package land.sungbin.androidplayground

import androidx.compose.runtime.NoLiveLiterals
import androidx.compose.runtime.movableContentOf
import androidx.compose.runtime.simulateHotReload
import androidx.compose.runtime.withRunningRecomposer

fun main() {
    setContent {
        movableContentOf {
            simulateHotReload(1)
        }
    }
}
