@file:Suppress(
    "unused",
    "UNUSED_VARIABLE",
    "UNUSED_PARAMETER", "FunctionName"
)

package land.sungbin.androidplayground.test

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Stable
import androidx.compose.runtime.State
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.staticCompositionLocalOf

val LocalNumber = compositionLocalOf { 0 }

private val LocalNormalText = compositionLocalOf { "TEST" }
private val LocalStaticText = staticCompositionLocalOf { "TEST2" }

/*internal class DynamicProvidableCompositionLocal<T> constructor(
    private val policy: SnapshotMutationPolicy<T>,
    defaultFactory: () -> T,
) : ProvidableCompositionLocal<T>()

internal class StaticProvidableCompositionLocal<T>(defaultFactory: () -> T) :
    ProvidableCompositionLocal<T>(defaultFactory) {

    @Composable
    override fun provided(value: T): State<T> = StaticValueHolder(value)
}*/

/*fun <T> compositionLocalOf(
    policy: SnapshotMutationPolicy<T> = structuralEqualityPolicy(),
    defaultFactory: () -> T,
): ProvidableCompositionLocal<T> = DynamicProvidableCompositionLocal(policy, defaultFactory)

fun <T> staticCompositionLocalOf(defaultFactory: () -> T): ProvidableCompositionLocal<T> =
    StaticProvidableCompositionLocal(defaultFactory)*/

fun main() {
    setContent {
        FirstComposable()
        SecondComposable()
        ThirdComposable()
    }
}

@Composable
fun FirstComposable() {
    // ...
}

@Composable
fun SecondComposable() {
    // ...
}

@Composable
fun ThirdComposable() {
    // ...
}

internal class LazyValueHolder<T>(valueProducer: () -> T) : State<T> {
    private val current by lazy(valueProducer)
    override val value: T get() = current
}

@Stable
sealed class CompositionLocal<T> constructor(defaultFactory: () -> T) {
    @Suppress("UNCHECKED_CAST")
    internal val defaultValueHolder = LazyValueHolder(defaultFactory)

    @Composable
    internal abstract fun provided(value: T): State<T>
}

class ProvidedValue<T> internal constructor(
    val compositionLocal: CompositionLocal<T>,
    val value: T,
    val canOverride: Boolean,
)

@Stable
abstract class ProvidableCompositionLocal<T>(defaultFactory: () -> T) :
    CompositionLocal<T>(defaultFactory) {

    infix fun provides(value: T) = ProvidedValue(
        compositionLocal = this,
        value = value,
        canOverride = true
    )

    infix fun providesDefault(value: T) = ProvidedValue(
        compositionLocal = this,
        value = value,
        canOverride = false
    )
}

internal class SlotTable {
    var groups = IntArray(0)
        private set

    var groupsSize = 0
        private set

    var slots = Array<Any?>(0) { null }
        private set

    var slotsSize = 0
        private set

    // more...
}


