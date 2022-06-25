@file:NoLiveLiterals

package land.sungbin.androidplayground.composable

import androidx.compose.runtime.Composable
import androidx.compose.runtime.NoLiveLiterals

@Composable
fun SingletonComposableLambda(content: @Composable () -> Unit) {
    content()
}

@Composable
fun CapturedComposableLambda(content: @Composable () -> Unit) {
    content()
}