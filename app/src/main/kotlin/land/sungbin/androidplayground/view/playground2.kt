@file:NoLiveLiterals

package land.sungbin.androidplayground.view

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.NoLiveLiterals
import androidx.compose.runtime.remember

class UnstableClass {
    val list = emptyList<Any>()
    fun unit() {}
}

class StableClass {
    fun unit() {}
}

@Composable
fun LambdaComposable(lambda: () -> Unit) {
    Text(text = lambda.toString())
}

@Composable
fun Content() {
    val stableClass = StableClass()
    val unstableClass = UnstableClass()

    LambdaComposable { unstableClass.unit() }
    LambdaComposable { stableClass.unit() }

    LambdaComposable(unstableClass::unit)
    LambdaComposable(stableClass::unit)
}

class UnstableClassUnit(private val unstableClass: UnstableClass) : Function0<Unit> {
    override operator fun invoke() {
        unstableClass.unit()
    }
}

@Composable
fun ContentAfter() {
    val stableClass = StableClass()
    val unstableClass = UnstableClass()

    LambdaComposable { UnstableClassUnit(unstableClass).invoke() }
    LambdaComposable(lambda = remember(stableClass) { { stableClass.unit() } })
}