package land.sungbin.androidplayground.invoker

import androidx.compose.runtime.Composable

@Composable
inline fun ComposableInvoker(content: @Composable () -> Unit) {
    content()
}
