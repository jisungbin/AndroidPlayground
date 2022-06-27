@file:Suppress(
    "SetTextI18n",
    "unused",
    "OPT_IN_IS_NOT_ENABLED",
    "SameParameterValue",
    "UNCHECKED_CAST",
    "LocalVariableName",
    "RemoveExplicitTypeArguments",
    "UnnecessaryOptInAnnotation",
    "ASSIGNED_BUT_NEVER_ACCESSED_VARIABLE",
    "UNUSED_VARIABLE",
    "UnusedImport",
    "CanBeVal",
    "UnrememberedMutableState"
)
@file:OptIn(
    ExperimentalMaterialApi::class,
    InternalComposeApi::class
)
@file:NoLiveLiterals

package land.sungbin.androidplayground.view

import android.os.Bundle
import android.widget.LinearLayout
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ProvideTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.InternalComposeApi
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.NoLiveLiterals
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.Snapshot
import androidx.compose.ui.graphics.Color
import androidx.core.view.WindowCompat
import androidx.databinding.DataBindingUtil
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import land.sungbin.androidplayground.R
import land.sungbin.androidplayground.composable.SortedColumn
import land.sungbin.androidplayground.databinding.ActivityMainBinding
import land.sungbin.androidplayground.theme.DefaultTextStyle
import land.sungbin.androidplayground.viewmodel.MainViewModel

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var binding: ActivityMainBinding
    private val vm: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.activity_main,
            LinearLayout(this),
            false
        )

        setContent {
            val systemUiController = rememberSystemUiController()
            var count by remember { mutableStateOf(0) }

            val unwrappedState = mutableStateOf(1)

            Snapshot.withMutableSnapshot {
                Snapshot.withMutableSnapshot {
                    Snapshot.withMutableSnapshot {
                        Snapshot.withMutableSnapshot {
                            // 여기에서 unwrappedState 에 대해 valid 가 실행된다면
                            // candidateSnapshot 의 아이디는 unwrappedState 가 생성된
                            // 글로벌 스냅샷의 아이디일 것이다.
                            // 하지만 이 곳의 currentSnapshot().id 의 값은
                            // 중첩된 만큼 id++ 가 된 값 이다.
                        }
                    }
                }
            }

            Snapshot.current.id.also(::println) // 5
            Snapshot.takeMutableSnapshot().also {
                it.id.also(::println) // 7
                it.enter {
                    Snapshot.current.id.also(::println) // 7
                }
                it.takeNestedMutableSnapshot().also { nestedIt ->
                    nestedIt.id.also(::println) // 9
                    nestedIt.enter {
                        Snapshot.current.id.also(::println) // 9
                    }
                    nestedIt.apply()
                }
                it.apply()
            }

            LaunchedEffect(Unit) {
                WindowCompat.setDecorFitsSystemWindows(window, false)
                systemUiController.setSystemBarsColor(color = Color.White)
                while (true) {
                    delay(1000)
                    count++
                }
            }

            val countAtRecomposition = Snapshot.withoutReadObservation {
                "Count: $count"
            }

            SortedColumn {
                ProvideTextStyle(DefaultTextStyle) {
                    Text(text = countAtRecomposition)
                    SideEffect {
                        println("Recomposed.")
                    }
                }
            }
        }
    }

    override fun onPause() {
        super.onPause()
        println("onPause")
    }
}