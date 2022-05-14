@file:Suppress("SetTextI18n", "unused")

package land.sungbin.androidplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import land.sungbin.androidplayground.databinding.ActivityMainBinding

class MainActivity : ComponentActivity() {

    private lateinit var binding: ActivityMainBinding
    private val vm: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Test()
        }

        /*binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        vm.printCurrentThreadName()
        binding.btnTest.setOnClickListener {
            measureNanoTime {
                lifecycleScope.launchWhenCreated {
                    withContext(Dispatchers.IO) {
                        withContext(Dispatchers.Main) {
                            binding.tvLabel.text = "Bye, world!"
                        }
                    }
                }
            }.also(::println)
        }

        binding.btnTestImmediate.setOnClickListener {
            measureNanoTime {
                lifecycleScope.launchWhenCreated {
                    withContext(Dispatchers.IO) {
                        withContext(Dispatchers.Main.immediate) {
                            binding.tvLabel.text = "Bye, world! with immediate"
                        }
                    }
                }
            }.also(::println)
        }*/
    }

    @Preview
    @Composable
    fun Test() {
        println(string(R.string.app_name) @Composable { stringResource(it) })
        Box(
            modifier = Modifier
                .fillMaxSize()
                .drawBehind {
                    drawRect(color = Color.Magenta)
                },
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Bye, world!")
        }
    }
}

@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
annotation class FunAnn

inline fun string(@StringRes resId: Int, builder: (resId: Int) -> String) = builder(resId)

@Composable
fun Test(content: @Composable (int: Int, argument: Any) -> Unit) {
    content(argument = "path", int = 1) // named-arguments in Lambda expression.
}
