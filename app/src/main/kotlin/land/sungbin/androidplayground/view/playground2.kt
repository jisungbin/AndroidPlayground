package land.sungbin.androidplayground.view

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

interface UnstableInterface

class UnstableClass : UnstableInterface {
    fun provideList() = emptyList<UnstableInterface>()
}

@Composable
fun Content() {
    val unstableClass = UnstableClass()
    UnstableComposable(unstableClass)
    LambdaComposable {
        unstableClass.provideList()
    }
}

@Composable
fun UnstableComposable(instance: UnstableInterface) {
    Text(text = instance.toString())
}

@Composable
fun LambdaComposable(lambda: () -> Unit) {
    Text(text = lambda.toString())
}