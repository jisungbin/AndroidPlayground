@file:NoLiveLiterals

package land.sungbin.androidplayground.extension

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.systemBars
import androidx.compose.runtime.Composable
import androidx.compose.runtime.NoLiveLiterals
import androidx.compose.runtime.NonRestartableComposable
import androidx.compose.ui.platform.LocalDensity

val StatusBarHeightDp
    @Composable
    @NonRestartableComposable
    get() = with(LocalDensity.current) {
        WindowInsets.systemBars.getTop(this).toDp()
    }
