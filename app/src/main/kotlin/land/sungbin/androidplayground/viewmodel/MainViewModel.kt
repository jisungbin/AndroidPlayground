@file:NoLiveLiterals

package land.sungbin.androidplayground.viewmodel

import androidx.compose.runtime.NoLiveLiterals
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.delay
import land.sungbin.androidplayground.state.LoadState

@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {
    suspend fun loadItems(): LoadState {
        delay(100)
        return LoadState.Done
    }
}
