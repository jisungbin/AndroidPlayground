package land.sungbin.androidplayground

sealed class LoadState {
    object Loading : LoadState()
    object Done : LoadState()
}
