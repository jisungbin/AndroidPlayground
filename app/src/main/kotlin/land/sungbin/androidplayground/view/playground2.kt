@file:NoLiveLiterals

package land.sungbin.androidplayground.view

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.NoLiveLiterals

interface EmptyInterface

const val StableValue = "Stable"

class UnstableClass : EmptyInterface {
    val list = emptyList<EmptyInterface>()
    fun provideList() = emptyList<EmptyInterface>()
}

@Composable
fun Content() {
    val unstableClass = UnstableClass()
    EmptyComposable(unstableClass)
    LambdaComposable {
        unstableClass.provideList()
    }
    LambdaComposable {
        println(StableValue)
    }
}

@Composable
fun EmptyComposable(instance: EmptyInterface) {
    Text(text = instance.toString())
}

@Composable
fun LambdaComposable(lambda: () -> Unit) {
    Text(text = lambda.toString())
}