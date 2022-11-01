package land.sungbin.androidplayground.view

import androidx.lifecycle.ViewModel

class AwesomeViewModel : ViewModel() {
    val number = 1
    override fun onCleared() {
        println("cleared")
        super.onCleared()
    }
}