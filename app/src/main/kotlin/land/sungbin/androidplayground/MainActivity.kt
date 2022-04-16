@file:Suppress("SetTextI18n")

package land.sungbin.androidplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import land.sungbin.androidplayground.databinding.ActivityMainBinding
import kotlin.system.measureNanoTime

class MainActivity : ComponentActivity() {

    private lateinit var binding: ActivityMainBinding
    private val vm: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

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
        }
    }
}
