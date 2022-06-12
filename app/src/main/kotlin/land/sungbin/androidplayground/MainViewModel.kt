@file:NoLiveLiterals

package land.sungbin.androidplayground

import androidx.compose.runtime.NoLiveLiterals
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.delay

class MainViewModel : ViewModel() {
    suspend fun loadItems(): LoadState {
        delay(100)
        return LoadState.Done
    }
}
