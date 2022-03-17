package land.sungbin.androidplayground

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class TestViewModel : ViewModel() {
    private val _sharedFlow = MutableSharedFlow<Int>()
    val sharedFlow = _sharedFlow.asSharedFlow()

    private val _channel = Channel<Int>()
    val channelFlow = _channel.receiveAsFlow()

    init {
        repeat(10) {
            emitting(it)
        }
    }

    fun emitting(value: Int) = viewModelScope.launch {
        _sharedFlow.emit(value)
        _channel.send(value)
    }
}
