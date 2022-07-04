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
import androidx.compose.ui.layout.MeasureScope

fun main() {
    setContent {
        movableContentOf {
            simulateHotReload(1)
        }
    }
}
