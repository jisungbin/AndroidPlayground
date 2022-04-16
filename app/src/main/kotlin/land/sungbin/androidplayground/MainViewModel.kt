package land.sungbin.androidplayground

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    fun printCurrentThreadName() {
        println(Thread.currentThread().name)
    }
}
