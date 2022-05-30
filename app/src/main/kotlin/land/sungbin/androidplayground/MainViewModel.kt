package land.sungbin.androidplayground

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val channel = Channel<Int>()
    private val sharedFlow = MutableSharedFlow<Int>()

    fun emit(value: Int) {
        viewModelScope.launch {
            channel.send(value)
            sharedFlow.emit(value)
        }
    }

    fun collect(action: (value: Int, type: String) -> Unit) {
        viewModelScope.launch {
            launch {
                channel.receiveAsFlow().collect { value ->
                    action(value, "channel")
                }
            }
            launch {
                sharedFlow.collect { value ->
                    action(value, "sharedFlow")
                }
            }
        }
    }

    companion object
}
