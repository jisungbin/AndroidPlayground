package land.sungbin.androidplayground.view

sealed class UiState {
    object Loading : UiState()
    object Done : UiState()
    data class Exception(val throwable: Throwable) : UiState()
}

