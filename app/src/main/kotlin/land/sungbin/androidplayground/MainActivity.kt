@file:Suppress(
    "SetTextI18n", "unused", "OPT_IN_IS_NOT_ENABLED", "SameParameterValue",
    "UNCHECKED_CAST"
)

package land.sungbin.androidplayground

import android.annotation.SuppressLint
import android.os.Binder
import android.os.Bundle
import android.os.Parcelable
import android.util.Size
import android.util.SizeF
import android.util.SparseArray
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import java.io.Serializable
import land.sungbin.androidplayground.databinding.ActivityMainBinding
import land.sungbin.androidplayground.test.BackHandlerTest
import land.sungbin.androidplayground.theme.DefaultTextStyle

private data class IntHolder(var value: Int)

private val AcceptableClasses = arrayOf(
    Serializable::class.java,
    Parcelable::class.java,
    String::class.java,
    SparseArray::class.java,
    Binder::class.java,
    Size::class.java,
    SizeF::class.java
)

class MainActivity : ComponentActivity() {

    private var state by mutableStateOf(1)
    private lateinit var binding: ActivityMainBinding
    private val vm: MainViewModel by viewModels()

    @SuppressLint("UnrememberedMutableState")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /*binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        vm.collect { value, type ->
            println("Collected $value from $type")
        }

        updateState()
        binding.btnTest.setOnClickListener {
            vm.emit(state++)
            updateState()
        }*/

        setContent {
            SideEffect {
                val intHolder = IntHolder(1)
                AcceptableClasses.forEach { instance ->
                    println("${instance.name}: ${instance.isInstance(intHolder)}")
                }
            }
            /*SideEffect {
                (arrayListOf(mutableStateOf(IntHolder(1))) as ArrayList<Parcelable>).also(::println)
            }*/

            LaunchedEffect(Unit) {
                window.setFlags( // 네비게이션바까지 영역 확장하려면 필요
                    WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                    WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
                )
                WindowCompat.setDecorFitsSystemWindows(window, false)
            }

            ProvideTextStyle(DefaultTextStyle) {
                val systemUiController = rememberSystemUiController()
                LaunchedEffect(Unit) {
                    systemUiController.setSystemBarsColor(color = Color.White)
                }

                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    contentAlignment = Alignment.Center,
                ) {
                    BackHandlerTest()
                }
            }
        }
    }

    private fun updateState() {
        binding.tvLabel.text = "State: $state"
    }
}
