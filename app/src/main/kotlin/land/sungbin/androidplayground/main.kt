import androidx.compose.runtime.mutableStateOf

val state = mutableStateOf(1)

fun main() {
    state.value = 1
    state.value = 2
    state.value = 3
}
