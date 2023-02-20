package land.sungbin.androidplayground

import androidx.core.content.ContextCompat.startActivity
import kotlinx.coroutines.flow.MutableStateFlow

enum class ExamScreen {
    Detail, Start Solving, Result;
}

object ExamScreenState {
    val state = MutableStateFlow(ExamScreen.Detail)
}

suspend fun activity() {
    ExamScreenState.state.collect { state ->
        when(state) {
            ExamScreen.Detail -> startActivity(ExamScreen.Detail)
            ExamScreen.Detail -> startActivity(ExamScreen.Start)
            ExamScreen.Solving -> startActivity(ExamScreen.Solving)
            ExamScreen.Result -> startActivity(ExamScreen.Result)
        }
    }
}
