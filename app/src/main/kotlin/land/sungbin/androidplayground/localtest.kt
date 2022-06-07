/*
@file:Suppress("RedundantVisibilityModifier", "unused", "UNUSED_PARAMETER", "UNUSED_VARIABLE")

package land.sungbin.androidplayground

import android.view.ViewGroup
import androidx.activity.ComponentActivity
import androidx.compose.runtime.Applier
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Composition
import androidx.compose.runtime.CompositionContext
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.saveable.LocalSaveableStateRegistry
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.platform.LocalSavedStateRegistryOwner
import androidx.compose.ui.platform.LocalView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner

val DefaultActivityContentLayoutParams: ViewGroup.LayoutParams?

val owner =
var disposed = false
var it =
var lastContent: @Composable () -> Unit =
var addedToLifecycle
var original =

interface A {
    fun dispose()
    fun onStateChanged()
    fun setContent(content: @Composable () -> Unit)
    fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event)
}

class B : A {

    override fun setContent(content: @Composable () -> Unit) {
       // ...
    }

    override fun dispose() {
        disposed = true
        original.dispose()
    }

    override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
        if (event == Lifecycle.Event.ON_DESTROY) {
            dispose()
        }
    }

}

val configuration,
val viewTreeOwners,
val saveableStateRegistry,

class AbstractComposeView {
    val view
    val context
}


internal fun ProvideAndroidCompositionLocals(
    owner: AbstractComposeView,
    content: @Composable () -> Unit,
) {
    val context = owner.context

    // ...

    CompositionLocalProvider(
        LocalConfiguration provides configuration,
        LocalContext provides context,
        LocalLifecycleOwner provides viewTreeOwners.lifecycleOwner,
        LocalSavedStateRegistryOwner provides viewTreeOwners.savedStateRegistryOwner,
        LocalSaveableStateRegistry provides saveableStateRegistry,
        LocalView provides owner.view,
        content = content
    )
}

class AndroidComposeView {
    val root
}

val wrapped = ;

private fun doSetContent(
    owner: AndroidComposeView,
    parent: CompositionContext,
    content: @Composable () -> Unit,
): Composition {
    val original = Composition(UiApplier(owner.root), parent)

    // ...

    wrapped.setContent(content)
    return wrapped
}

fun UiApplier(root: Any): Applier<*> {


}

//parent CompositionContext 를 설정해 줍니다. 이때 주입되는 parent 는 null 이므로 내부에서 위에서 봤던 View.createLifecycleAwareWindowRecomposer() 를 통해 다시 만들게 됩니다.
//ComposeView.setContent() 를 통해 ComposeView 에 content 를 설정합니다.
//ComposeView.Owners() 를 통해 ComposeView 를 Owner 로 설정합니다.
//마지막으로 ComponentActivity.setContentView() 를 통해 ComposeView 를 content 로 설정합니다.

public fun ComponentActivity.setContent(
    parent: CompositionContext? = null,
    content: @Composable () -> Unit,
) {
    // ...

    ComposeView(this).apply {
        setParentCompositionContext(parent) // 1. CompositionContext 설정
        setContent(content) // 2. ComposeView 에 composable content 를 설정
        setOwners() // 3. ComposeView 를 Owner 로 설정
        setContentView(this, DefaultActivityContentLayoutParams) // 4. ComponentActivity 에 ComposeView 로 content 설정
    }
}

fun ComposeView.setOwners() {


}
*/
