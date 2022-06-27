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
            // 글로벌 스냅샷 아이디: 1 (가정)

            Snapshot.withMutableSnapshot {
                // 중첩 스냅샷 아이디: 2 (가정)
                Snapshot.withMutableSnapshot {
                    // 중첩 스냅샷 아이디: 3 (가정)
                    Snapshot.withMutableSnapshot {
                        // 중첩 스냅샷 아이디: 4 (가정)
                        Snapshot.withMutableSnapshot {
                            // 중첩 스냅샷 아이디: 5 (가정)

                            // 여기에서 unwrappedState 에 대해 valid 가 실행된다면
                            // candidateSnapshot 의 아이디는 레코드가 생성되는
                            // 스냅샷의 아이디일 것이다.
                            // 즉, 1~5 의 아이디를 가질 수 있다.

                            // 이 곳의 currentSnapshot().id 의 값은
                            // 중첩된 아이디만큼 5 가 된다.

                            // 따라서 candidateSnapshot <= currentSnapshot 가
                            // 항상 성립해야 한다.
                        }
                    }
                }
            }

            SideEffect {
                val snap1 = Snapshot.takeMutableSnapshot()
                snap1.enter {
                    count = 2
                    Snapshot.withMutableSnapshot {
                        count = 3
                    }
                }
                count.also(::println)
            }

            LaunchedEffect(Unit) {
                WindowCompat.setDecorFitsSystemWindows(window, false)
                systemUiController.setSystemBarsColor(color = Color.White)
            }

            SortedColumn {
                ProvideTextStyle(DefaultTextStyle) {
                    Text(text = "Count: $count")
                }
            }
        }
    }
}