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
