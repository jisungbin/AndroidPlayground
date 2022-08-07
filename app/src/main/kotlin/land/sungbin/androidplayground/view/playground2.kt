@file:NoLiveLiterals

package land.sungbin.androidplayground.view

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.NoLiveLiterals

class UnstableClass {
    val list = emptyList<Any>()
    fun unit() {}
}

class StableClass {
    fun unit() {}
}

@Composable
fun Content() {
    val stableValue = "Stable"
    val stableClass = StableClass()
    val unstableClass = UnstableClass()

    LambdaComposable { unstableClass.unit() }
    LambdaComposable { println(stableValue) }
    LambdaComposable { stableClass.unit() }
    LambdaComposable(unstableClass::unit)
    LambdaComposable(stableClass::unit)
}

@Composable
fun LambdaComposable(lambda: () -> Unit) {
    Text(text = lambda.toString())
}