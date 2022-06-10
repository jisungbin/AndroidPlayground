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
    "UNUSED_VARIABLE"
)
@file:OptIn(
    ExperimentalMaterialApi::class,
    InternalComposeApi::class
)

package land.sungbin.androidplayground

import android.os.Bundle
import android.os.Parcelable
import android.view.WindowManager
import android.widget.LinearLayout
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ProvideTextStyle
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.InternalComposeApi
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import androidx.databinding.DataBindingUtil
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import kotlinx.parcelize.Parcelize
import land.sungbin.androidplayground.databinding.ActivityMainBinding
import land.sungbin.androidplayground.theme.DefaultTextStyle

@Parcelize
data class People(val name: String, val age: Int) : Parcelable

class MainActivity : ComponentActivity() {

    private lateinit var binding: ActivityMainBinding
    private val vm: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.inflate(layoutInflater,
            R.layout.activity_main,
            LinearLayout(this),
            false)
        (binding.root.context as MainActivity).also(::println)

        setContent {
            val systemUiController = rememberSystemUiController()

            LaunchedEffect(Unit) {
                window.setFlags( // 네비게이션바까지 영역 확장하려면 필요
                    WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                    WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
                )
                WindowCompat.setDecorFitsSystemWindows(window, false)
                systemUiController.setSystemBarsColor(color = Color.White)
            }

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                contentAlignment = Alignment.Center,
            ) {
                ProvideTextStyle(DefaultTextStyle.copy()) {
                    CompositionTest()
                }
            }
        }
    }
}

@Composable
fun CompositionTest() {
    var text by remember { mutableStateOf("") }

    LoggingButton(onClick = { text = "$text\n$text" }) {
        LoggingText(text)
    }
}

@Composable
fun LoggingButton(
    onClick: () -> Unit,
    content: @Composable RowScope.() -> Unit,
) {
    SideEffect {
        println("Button composition.")
    }
    Button(onClick = onClick, content = content)
}

@Composable
fun LoggingText(text: String) {
    SideEffect {
        println("Text composition.")
    }
    Text(text)
}