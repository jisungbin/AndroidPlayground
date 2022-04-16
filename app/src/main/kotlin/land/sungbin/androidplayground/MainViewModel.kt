package land.sungbin.androidplayground

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

class MainViewModel : ViewModel() {
    private val coroutineContext = viewModelScope
}
