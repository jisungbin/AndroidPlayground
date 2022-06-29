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
    "UnrememberedMutableState",
    "ComposableNaming",
    "SpellCheckingInspection"
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

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.animation.BounceInterpolator
import android.widget.LinearLayout
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.SizeTransform
import androidx.compose.animation.animateColor
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.AnimationVector1D
import androidx.compose.animation.core.AnimationVector2D
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.SpringSpec
import androidx.compose.animation.core.TweenSpec
import androidx.compose.animation.core.TwoWayConverter
import androidx.compose.animation.core.VectorConverter
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateValueAsState
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.with
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.ProvideTextStyle
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.InternalComposeApi
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat
import androidx.databinding.DataBindingUtil
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint
import kotlin.math.roundToInt
import kotlin.random.Random
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
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
                AnimatedContentSizeTransform()
            }
        }
    }
}

@Preview
@Composable
private fun Content() {
    SortedColumn {
        var selected by remember { mutableStateOf(false) }
        val transition = updateTransition(
            targetState = selected,
            label = "transition",
        )
        val borderColor by transition.animateColor(label = "borderColor") { isSelected ->
            if (isSelected) Color.Magenta else Color.White
        }
        val elevation by transition.animateDp(label = "elevation") { isSelected ->
            if (isSelected) 10.dp else 2.dp
        }

        Surface(
            onClick = { selected = !selected },
            shape = RoundedCornerShape(8.dp),
            border = BorderStroke(2.dp, borderColor),
            elevation = elevation
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(text = "Hello, world!")
                transition.AnimatedVisibility(
                    visible = { targetSelected -> targetSelected },
                    enter = expandVertically(),
                    exit = shrinkVertically()
                ) {
                    Text(text = "It is fine today.")
                }
                transition.AnimatedContent { targetState ->
                    if (targetState) {
                        Text(text = "Selected")
                    } else {
                        Icon(
                            imageVector = Icons.Default.Phone,
                            contentDescription = "Phone"
                        )
                    }
                }
            }
        }
    }
}

private fun expandFading(time: Int) = fadeIn(
    animationSpec = tween(time * 3)
) with fadeOut(animationSpec = tween(time))

private fun expandSizing(time: Int) = SizeTransform { initialSize, targetSize ->
    keyframes {
        IntSize(targetSize.width, initialSize.height) at time
        durationMillis = time * 3
    }
}

private fun shrinkFading(time: Int) = fadeIn(
    animationSpec = tween(
        durationMillis = time,
        delayMillis = time * 2
    )
) with fadeOut(animationSpec = tween(time * 3))

private fun shrinkSizing(time: Int) = SizeTransform { initialSize, targetSize ->
    keyframes {
        IntSize(initialSize.width, targetSize.height) at time
        durationMillis = time * 3
    }
}

@Composable
fun AnimatedContentSizeTransform() {
    val time = 500
    SortedColumn {
        var expanded by remember { mutableStateOf(false) }

        AnimatedContent(
            targetState = expanded,
            transitionSpec = {
                if (targetState) {
                    expandFading(time) using expandSizing(time)
                } else {
                    shrinkFading(time) using shrinkSizing(time)
                }
            }
        ) { targetExpanded ->
            Box(
                modifier = Modifier
                    .size(250.dp)
                    .background(
                        when (targetExpanded) {
                            true -> Color.Pink
                            else -> Color.LightGray
                        }
                    )
            )
        }

        Button(onClick = { expanded = !expanded }) {
            Text(if (expanded) "Hide" else "Show")
        }
    }
}