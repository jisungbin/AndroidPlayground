@file:Suppress("MayBeConstant")

package land.sungbin.androidplayground.view

import androidx.compose.runtime.Composable

val VALUE = "value"
val NonCaptureLambda = { println("Bye, World!") }
val CaptureLambda = { println(VALUE) }

@Composable
fun Playground3Content() {
    NonCaptureLambda()
    CaptureLambda()
}