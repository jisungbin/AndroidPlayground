package land.sungbin.androidplayground.view

import android.provider.SyncStateContract.Helpers.update
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposeCompilerApi
import androidx.compose.runtime.Composer
import androidx.compose.runtime.Composition
import androidx.compose.runtime.CompositionContext
import androidx.compose.runtime.CompositionImpl
import androidx.compose.runtime.ControlledComposition
import androidx.compose.runtime.InvalidationResult
import androidx.compose.runtime.Stable
import androidx.compose.runtime.collection.IdentityArraySet
import androidx.compose.runtime.internal.ComposableLambda
import androidx.compose.runtime.internal.ComposableLambdaImpl
import androidx.compose.runtime.internal.differentBits
import androidx.compose.runtime.internal.sameBits
import androidx.compose.runtime.snapshots.Snapshot
import androidx.compose.runtime.snapshots.fastForEach
import androidx.compose.runtime.trace
import androidx.compose.ui.node.UiApplier
import androidx.compose.ui.platform.AndroidComposeView
import androidx.compose.ui.platform.ProvideAndroidCompositionLocals
import androidx.compose.ui.tooling.ComposableInvoker.invokeComposable
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import kotlinx.coroutines.NonDisposableHandle.parent

private fun doSetContent(
    owner: AndroidComposeView,
    parent: CompositionContext,
    content: @Composable () -> Unit
): Composition {
    val original = Composition(UiApplier(owner.root), parent)
    val wrapped = WrappedComposition(owner, original)
    wrapped.setContent(content)
    return wrapped
}

private class WrappedComposition(
    val owner: AndroidComposeView,
    val original: Composition
) : Composition, LifecycleEventObserver {
    private var disposed = false
    private var addedToLifecycle: Lifecycle? = null
    private var lastContent: @Composable () -> Unit = {}

    override fun setContent(content: @Composable () -> Unit) {
        owner.setOnViewTreeOwnersAvailable {
            if (!disposed) {
                val lifecycle = it.lifecycleOwner.lifecycle
                lastContent = content
                if (addedToLifecycle == null) {
                    addedToLifecycle = lifecycle
                    lifecycle.addObserver(this)
                } else if (lifecycle.currentState.isAtLeast(Lifecycle.State.CREATED)) {
                    original.setContent {
                        ProvideAndroidCompositionLocals(owner, content)
                    }
                }
            }
        }
    }

    override fun dispose() {
        if (!disposed) {
            disposed = true
            addedToLifecycle?.removeObserver(this)
        }
        original.dispose()
    }

    override val hasInvalidations get() = original.hasInvalidations
    override val isDisposed get() = original.isDisposed

    override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
        if (event == Lifecycle.Event.ON_DESTROY) {
            dispose()
        } else if (event == Lifecycle.Event.ON_CREATE) {
            if (!disposed) {
                setContent(lastContent)
            }
        }
    }
}

private class WrappedComposition(
    val owner: AndroidComposeView,
    val original: Composition
) : Composition, LifecycleEventObserver {
    // ...

    override fun setContent(content: @Composable () -> Unit) {
        // ...
        original.setContent {
            ProvideAndroidCompositionLocals(owner, content)
        }
    }
}

// Composition#setContent
override fun setContent(content: @Composable () -> Unit) {
    this.composable = content
    // parent: Recomposer
    parent.composeInitial(this, composable)
}

internal override fun composeInitial(
    composition: ControlledComposition,
    content: @Composable () -> Unit
) {
    val composerWasComposing = composition.isComposing
    composing(composition, null) {
        composition.composeContent(content)
    }
    if (!composerWasComposing) {
        Snapshot.notifyObjectsInitialized()
    }
    if (_state.value > State.ShuttingDown) {
        if (composition !in knownCompositions) {
            knownCompositions += composition
        }
    }
    composition.applyChanges()
    composition.applyLateChanges()
}

// file: Composition.kt

override fun composeContent(content: @Composable () -> Unit) {
    composer.doCompose(takeInvalidations(), content)
}

private fun takeInvalidations(): IdentityArrayMap<RecomposeScopeImpl, IdentityArraySet<Any>?> {
    val invalidations = invalidations
    this.invalidations = IdentityArrayMap()
    return invalidations
}

private fun doCompose(
    invalidationsRequested: IdentityArrayMap<RecomposeScopeImpl, IdentityArraySet<Any>?>,
    content: (@Composable () -> Unit)?
) {
    invalidationsRequested.forEach { scope, set ->
        val location = scope.anchor?.location ?: return
        invalidations.add(Invalidation(scope, location, set))
    }
    invalidations.sortBy { it.location }

    startRoot()
    startGroup(invocationKey, invocation)
    invokeComposable(this, content)
    endGroup()
    endRoot()
}

override fun applyChanges() {
    applyChangesInLocked(changes)
}

override fun applyLateChanges() {
    if (lateChanges.isNotEmpty()) {
        applyChangesInLocked(lateChanges)
    }
}

private fun applyChangesInLocked(changes: MutableList<Change>) {
    val manager = CompositionImpl.RememberEventDispatcher(abandonSet)
    try {
        if (changes.isEmpty()) return
        applier.onBeginChanges()

        slotTable.write { slots ->
            val applier = applier
            changes.fastForEach { change ->
                change(applier, slots, manager)
            }
            changes.clear()
        }

        applier.onEndChanges()
    }

    manager.dispatchRememberObservers()
    manager.dispatchSideEffects()

    if (pendingInvalidScopes) {
        trace("Compose:unobserve") {
            pendingInvalidScopes = false
            observations.removeValueIf { scope -> !scope.valid }
            cleanUpDerivedStateObservations()
        }
    }
} finally {
    // Only dispatch abandons if we do not have any late changes. The instances in the
    // abandon set can be remembered in the late changes.
    if (this.lateChanges.isEmpty())
        manager.dispatchAbandons()
}
}

@ComposeCompilerApi
fun composableLambda(
    composer: Composer,
    key: Int,
    tracked: Boolean,
    block: Any
): ComposableLambda {
    composer.startReplaceableGroup(key)
    val slot = composer.rememberedValue()
    val result = if (slot === Composer.Empty) {
        val value = ComposableLambdaImpl(key, tracked)
        composer.updateRememberedValue(value)
        value
    } else {
        slot as ComposableLambdaImpl
    }
    result.update(block)
    composer.endReplaceableGroup()
    return result
}

@ComposeCompilerApi
fun composableLambdaInstance(
    key: Int,
    tracked: Boolean,
    block: Any
): ComposableLambda = ComposableLambdaImpl(key, tracked).apply { update(block) }

@Stable
internal actual class ComposableLambdaImpl actual constructor(
    val key: Int,
    private val tracked: Boolean
) : ComposableLambda {
    // ...

    override operator fun invoke(c: Composer, changed: Int): Any? {
        val c = c.startRestartGroup(key)
        trackRead(c)
        val dirty = changed or if (c.changed(this)) differentBits(0) else sameBits(0)
        // _block 이 content 가 됩니다.
        val result = (_block as (c: Composer, changed: Int) -> Any?)(c, dirty)
        c.endRestartGroup()?.updateScope(this as (Composer, Int) -> Unit)
        return result
    }
}

private inline fun <T> composing(
    composition: ControlledComposition,
    modifiedValues: IdentityArraySet<Any>?,
    block: () -> T
): T {
    val snapshot = Snapshot.takeMutableSnapshot(
        readObserverOf(composition), writeObserverOf(composition, modifiedValues)
    )
    try {
        return snapshot.enter(block)
    } finally {
        applyAndCheck(snapshot)
    }
}

private fun readObserverOf(composition: ControlledComposition): (Any) -> Unit {
    return { value -> composition.recordReadOf(value) }
}

private fun writeObserverOf(
    composition: ControlledComposition,
    modifiedValues: IdentityArraySet<Any>?
): (Any) -> Unit {
    return { value ->
        composition.recordWriteOf(value)
        modifiedValues?.add(value)
    }
}

// Composition.kt
override fun recordReadOf(value: Any) {
    composer.currentRecomposeScope?.let {
        it.used = true
        observations.add(value, it)
    }
}

// Composition.kt
override fun recordWriteOf(value: Any) {
    observations.forEachScopeOf(value) { scope ->
        // scope: RecomposeScope
        // 여러번 델리게이트 되다가 결국 해당 scope 로
        // Recomposer#invalidation 이 호출됩니다.
    }
}

// Recomposer.kt
internal override fun invalidate(composition: ControlledComposition) {
    synchronized(stateLock) {
        if (composition !in compositionInvalidations) {
            compositionInvalidations += composition
            deriveStateLocked()
        } else null
    }?.resume(Unit)
}