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
    InternalComposeApi::class,
    ExperimentalLayoutApi::class,
    ExperimentalMaterialApi::class,
    ExperimentalComposeUiApi::class,
    ExperimentalFoundationApi::class,
    ExperimentalAnimationApi::class,
)

package land.sungbin.androidplayground.view

import android.os.Bundle
import android.widget.LinearLayout
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.AnimationVector2D
import androidx.compose.animation.core.TwoWayConverter
import androidx.compose.animation.core.animateValueAsState
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.size
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ProvideTextStyle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.InternalComposeApi
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat
import androidx.databinding.DataBindingUtil
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint
import kotlin.random.Random
import kotlinx.coroutines.delay
import land.sungbin.androidplayground.R
import land.sungbin.androidplayground.composable.SortedColumn
import land.sungbin.androidplayground.databinding.ActivityMainBinding
import land.sungbin.androidplayground.theme.BackgroundWhite
import land.sungbin.androidplayground.theme.NanumGothicTextStyle
import land.sungbin.androidplayground.theme.Pink
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

            var visibilityState by remember { mutableStateOf(true) }
            var selectedColorState by remember { mutableStateOf(Color.Red) }

            LaunchedEffect(Unit) {
                WindowCompat.setDecorFitsSystemWindows(window, false)
                systemUiController.setStatusBarColor(
                    color = Color.Transparent,
                    darkIcons = true
                )
                systemUiController.setNavigationBarColor(
                    color = Color.BackgroundWhite,
                    darkIcons = true
                )
            }

            ProvideTextStyle(NanumGothicTextStyle) {
                Content()
            }
        }
    }
}

private const val TransitionLabel = "AwesomeLabel"

private enum class VisibilityState {
    Visible, Hide
}

private data class Size(val width: Dp, val height: Dp)


@Preview
@Composable
private fun Content() {
    SortedColumn {
        var targetSize by remember { mutableStateOf(Size(100.dp, 100.dp)) }
        val animationSize by animateValueAsState<Size, AnimationVector2D>(
            targetValue = targetSize,
            typeConverter = TwoWayConverter(
                convertToVector = { size ->
                    AnimationVector2D(size.width.value, size.height.value)
                },
                convertFromVector = { vector ->
                    Size(vector.v1.dp, vector.v2.dp)
                }
            )
        )

        LaunchedEffect(Unit) {
            delay(1000)
            targetSize = Size(250.dp, 250.dp)
        }

        Box(
            modifier = Modifier
                .animateContentSize()
                .size(animationSize.width, animationSize.height)
                .background(color = Color.Pink)
                .clickable {
                    val size = Random.nextInt(100, 250)
                    targetSize = Size(size.dp, size.dp)
                }
        )
    }
}