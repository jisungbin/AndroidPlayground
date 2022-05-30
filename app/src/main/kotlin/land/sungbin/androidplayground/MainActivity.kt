@file:Suppress(
    "SetTextI18n",
    "unused",
    "OPT_IN_IS_NOT_ENABLED",
    "SameParameterValue",
    "UNCHECKED_CAST",
    "LocalVariableName",
    "RemoveExplicitTypeArguments",
    "UnnecessaryOptInAnnotation"
)
@file:OptIn(
    ExperimentalMaterialApi::class,
    InternalComposeApi::class
)

package land.sungbin.androidplayground

import android.os.Bundle
import android.os.Parcelable
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ProvideTextStyle
import androidx.compose.runtime.InternalComposeApi
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import kotlinx.coroutines.delay
import kotlinx.parcelize.Parcelize
import land.sungbin.androidplayground.databinding.ActivityMainBinding
import land.sungbin.androidplayground.test.StateQuiz
import land.sungbin.androidplayground.theme.DefaultTextStyle

@Parcelize
data class People(val name: String, val age: Int) : Parcelable

class MainActivity : ComponentActivity() {

    private lateinit var binding: ActivityMainBinding
    private val vm: MainViewModel by viewModels()
    private lateinit var onBackPressedAction: () -> Unit

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
            val systemUiController = rememberSystemUiController()
            var state by remember { mutableStateOf(1) }

            LaunchedEffect(Unit) {
                window.setFlags( // 네비게이션바까지 영역 확장하려면 필요
                    WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                    WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
                )
                WindowCompat.setDecorFitsSystemWindows(window, false)
                systemUiController.setSystemBarsColor(color = Color.White)

//                println("sleeping with $state")
                delay(100)
//                println("1000 slept with $state")
                state++
            }
/*
            SideEffect {
                lifecycleScope.launchWhenCreated {
                    delay(500)
                    println("increase state to 2")
                    state++
                }
            }*/

            /*BackHandler(enabled = bottomSheetState.isVisible) {
                coroutineScope.launch {
                    bottomSheetState.hide()
                }
            }*/

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                contentAlignment = Alignment.Center,
            ) {
                ProvideTextStyle(DefaultTextStyle) {
                    StateQuiz(state)
                }
            }

            /*ModalBottomSheetLayout(
                sheetState = bottomSheetState,
                sheetShape = RoundedCornerShape(
                    topStart = 30.dp,
                    topEnd = 30.dp
                ),
                sheetBackgroundColor = MaterialTheme.colorScheme.surfaceVariant,
                sheetContent = {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(300.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Bye, world!",
                            style = DefaultTextStyle
                        )

                    }
                },
                content = {}
            )*/
        }
    }

    /*private fun updateState() {
        binding.tvLabel.text = "State: $state"
    }*/

    /*override fun onBackPressed() {
        onBackPressedAction()
    }*/
}
