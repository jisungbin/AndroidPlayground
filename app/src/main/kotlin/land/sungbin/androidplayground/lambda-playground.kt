@file:NoLiveLiterals

package land.sungbin.androidplayground

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

    // after compile:
    // LambdaComposable((Function0)(new Function0(unstableClass) {
    //   public final void invoke() {
    //     ((UnstableClass)this.receiver).unit();
    //   }
    // }), $composer, 0);
    // but this is Stable. So, can skip recomposition.
    LambdaComposable(unstableClass::unit)

    // after compile:
    // LambdaComposable(lambda = remember(stableClass) { { stableClass.unit() } })
    // So, this is stable and can skip recomposition.
    LambdaComposable(stableClass::unit)
}
