@file:NoLiveLiterals

package land.sungbin.androidplayground.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.NoLiveLiterals

private const val VALUE = 1

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val capturedLambda = {
                println(VALUE)
                VALUE
            }
            val uncapturedLambda = {
                println("VALUE")
                "VALUE"
            }

            val capturedComposabeLambda = @Composable {
                println(VALUE)
                VALUE
            }
            val uncapturedComposableLambda = @Composable {
                println("VALUE")
                "VALUE"
            }

            invokeLambda(capturedLambda)
            invokeLambda(uncapturedLambda)
            invokeComposableLambda(capturedComposabeLambda)
            invokeComposableLambda(uncapturedComposableLambda)
        }
    }

    @Composable
    private fun invokeComposableLambda(content: @Composable () -> Any) {
        content()
    }

    private fun invokeLambda(content: () -> Any) {
        content()
    }
}
