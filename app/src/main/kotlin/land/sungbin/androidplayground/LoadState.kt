@file:NoLiveLiterals

package land.sungbin.androidplayground

import androidx.compose.runtime.NoLiveLiterals

sealed class LoadState {
    object Loading : LoadState()
    object Done : LoadState()
}
