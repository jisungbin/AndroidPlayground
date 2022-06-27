@file:Suppress(
    "RedundantUnitReturnType",
    "unused",
    "UnusedImport"
)
@file:NoLiveLiterals

package land.sungbin.androidplayground

import androidx.compose.runtime.ControlledComposition
import androidx.compose.runtime.MovableContentStateReference
import androidx.compose.runtime.NoLiveLiterals
import androidx.compose.runtime.Recomposer
import androidx.compose.runtime.movableContentOf
import androidx.compose.runtime.simulateHotReload
import androidx.compose.runtime.snapshots.Snapshot
import androidx.compose.runtime.withRunningRecomposer
import kotlin.coroutines.resume
import kotlinx.coroutines.CancellableContinuation
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Job
import land.sungbin.androidplayground.test.setContent

fun main() {
    setContent {
        movableContentOf {
            simulateHotReload(1)
        }
    }
}