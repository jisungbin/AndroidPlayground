@file:Suppress(
    "unused",
    "UNUSED_PARAMETER",
    "FunctionName",
    "UnrememberedMutableState",
    "ASSIGNED_BUT_NEVER_ACCESSED_VARIABLE",
    "LocalVariableName",
    "UNUSED_VALUE"
)

package land.sungbin.androidplayground.test

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.ProduceStateScope
import androidx.compose.runtime.SnapshotMutationPolicy
import androidx.compose.runtime.State
import androidx.compose.runtime.cache
import androidx.compose.runtime.currentComposer
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.produceState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.runtime.structuralEqualityPolicy
import kotlin.coroutines.CoroutineContext
import kotlinx.coroutines.delay
import kotlinx.coroutines.suspendCancellableCoroutine
import land.sungbin.androidplayground.LoadState
import land.sungbin.androidplayground.MainViewModel

@Composable
fun ItemLoadOriginal(vm: MainViewModel) {
    var loadState by remember { mutableStateOf<LoadState>(LoadState.Loading) }
    LaunchedEffect(vm) {
        loadState = vm.loadItems()
    }
    Text(
        text = when (loadState) {
            LoadState.Loading -> "Loading..."
            LoadState.Done -> "Done!"
        }
    )
}

@Composable
fun ProduceStateTest() {
    val number by produceState(initialValue = 1) {
        println("value update pending...")
        delay(1000) // network call
        println("value updated to 2")
        value = 2

        awaitDispose {
            println("Disposed.")
        }
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

    fun main() {
        var Z by mutableStateOf(1)
        Z = 20
    }

fun ShowValue(value: Any) {}

//fun ShowWantChar(wantChar: Char) {}

@Composable
fun ShowWantChar(wantChar: Char) {
    val items = remember { '가'..'힣' }
    val wantCharState by rememberUpdatedState(wantChar)
    val foundChar by remember(items) {
        derivedStateOf { items.find { it == wantCharState } }
    }
    Text(foundChar.toString())
}

/*@Composable
fun ShowWantChar(wantChar: Char) {
    val items = remember { '가'..'힣' }
    val wantCharState by rememberUpdatedState(wantChar)
    val foundChar by remember(items) {
        mutableStateOf(items.find { it == wantCharState })
    }
    Text(foundChar.toString())
}*/

@Composable
fun StateTest(value: Any) {
    // remember 에 의해 State 객체가 저장되서 value 가 바뀌어도
    // 다시 할당되지 않음
    // -> 다시 바꿀려면 remember 에 value 키를 넣어야 함
    val state by remember { derivedStateOf { value } }
    println("[StateTest] Composition with $state")
    LaunchedEffect(Unit) {
        println("[StateTest] Launched with $state")
        delay(1000)
        println("[StateTest] 1000 slept with $state")
    }
    Text(text = state.toString())
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

private class ProduceStateScopeImpl<T>(
    state: androidx.compose.runtime.MutableState<T>,
    override val coroutineContext: CoroutineContext,
) : ProduceStateScope<T>, androidx.compose.runtime.MutableState<T> by state {

    override suspend fun awaitDispose(onDispose: () -> Unit): Nothing {
        try {
            suspendCancellableCoroutine<Nothing> { }
        } finally {
            onDispose()
        }
    }
}

@Composable
fun <T> produceState(
    initialValue: T,
    vararg keys: Any?,
    producer: suspend ProduceStateScope<T>.() -> Unit,
): State<T> {
    val result = remember { mutableStateOf(initialValue) }
    LaunchedEffect(keys = keys) {
        ProduceStateScopeImpl(result, coroutineContext).producer()
    }
    return result
}

@Composable
fun ItemLoad(vm: MainViewModel) {
    val loadState by produceState<LoadState>(initialValue = LoadState.Loading, key1 = vm) {
        value = vm.loadItems()
    }
    Text(
        text = when (loadState) {
            LoadState.Loading -> "Loading..."
            LoadState.Done -> "Done!"
        }
    )
}
