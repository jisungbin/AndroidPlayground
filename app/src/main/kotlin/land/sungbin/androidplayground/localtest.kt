@file:Suppress(
    "RedundantUnitReturnType",
    "unused",
    "UnusedImport"
)
@file:NoLiveLiterals

package land.sungbin.androidplayground

import androidx.compose.runtime.NoLiveLiterals
import androidx.compose.runtime.movableContentOf
import androidx.compose.runtime.simulateHotReload
import androidx.compose.runtime.withRunningRecomposer
import land.sungbin.androidplayground.test.setContent

fun main() {
    setContent {
        movableContentOf {
            simulateHotReload(1)
        }
    }
}
