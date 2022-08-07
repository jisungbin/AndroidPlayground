@file:Suppress("PropertyName", "MemberVisibilityCanBePrivate")
@file:NoLiveLiterals

package land.sungbin.androidplayground.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.NoLiveLiterals

val EmptyLambdaInFile = {}

class MainActivity : ComponentActivity() {
    var mutableValue = 0
    val EmptyLambdaInActivity = {}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LambdaComposable(lambda = EmptyLambdaInFile)
            LambdaComposable(lambda = EmptyLambdaInActivity)
        }
    }
}

@Composable
fun LambdaComposable(lambda: () -> Unit) {
    Text(text = lambda.toString())
}