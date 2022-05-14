package land.sungbin.androidplayground

import androidx.compose.runtime.Composable

@Composable
fun LambdaOptimizedTest(
    nonComposableLambdaExpression: () -> Unit,
    composableLambdaExpression: @Composable () -> Unit,
) {
    nonComposableLambdaExpression()
    composableLambdaExpression()
}
