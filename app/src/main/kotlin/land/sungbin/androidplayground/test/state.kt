@file:Suppress(
    "unused",
    "UNUSED_PARAMETER"
)

package land.sungbin.androidplayground.test

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SnapshotMutationPolicy
import androidx.compose.runtime.State
import androidx.compose.runtime.cache
import androidx.compose.runtime.currentComposer
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.produceState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.runtime.structuralEqualityPolicy
import kotlinx.coroutines.delay

@Composable
fun ProduceStateTest() {
    val number by produceState(initialValue = 1) {
        delay(1000) // network call
        value = 2
    }
    Text(text = number.toString())
}

@Composable
fun RememberUpdateStateTest(value: Any) {
    val state by rememberUpdatedState(value)
    println("[RememberUpdateStateTest] Composition with $state")
    LaunchedEffect(Unit) {
        println("[RememberUpdateStateTest] Launched with $state")
        delay(1000)
        println("[RememberUpdateStateTest] 1000 slept with $state")
    }
    Text(text = state.toString())
}

@Composable
fun StateTest(value: Any) {
    // remember 에 의해 State 객체가 저장되서 value 가 바뀌어도
    // 다시 할당되지 않음
    // -> 다시 바꿀려면 remember 에 value 키를 넣어야 함
    val state by remember { mutableStateOf(value) }
    println("[StateTest] Composition with $state")
    LaunchedEffect(Unit) {
        println("[StateTest] Launched with $state")
        delay(1000)
        println("[StateTest] 1000 slept with $state")
    }
    Text(text = state.toString())
}

fun main() {
    setContent {
        var state by remember { mutableStateOf(1) }

        LaunchedEffect(Unit) {
            delay(100)
            state++
        }

        StateQuiz(value = state)
    }
}

    @Composable
    fun StateQuiz(value: Any) {
        val state by rememberUpdatedState(value)
        println("Composition with $state") // Composition with 1, Composition with 2

        LaunchedEffect(Unit) {
            println("Launched with $state") // Launched with 1
            delay(1000)
            println("1000 slept with $state") // 1000 slept with 2
        }

        Text(state.toString())
    }

interface MutableState<T>

fun <T> createSnapshotMutableState(
    value: T,
    policy: Any,
) = object : MutableState<T> {}

fun <T> mutableStateOf(
    value: T,
    policy: SnapshotMutationPolicy<T> = structuralEqualityPolicy(),
): MutableState<T> = createSnapshotMutableState(value, policy)

@Composable
fun <T> rememberUpdatedState(newValue: T): State<T> = remember {
    mutableStateOf(newValue)
}.apply { value = newValue }

@Composable
inline fun <T> remember(calculation: () -> T): T =
    currentComposer.cache(false, calculation)
