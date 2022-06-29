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
)
@file:NoLiveLiterals

package land.sungbin.androidplayground.view

import android.os.Bundle
import android.widget.LinearLayout
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.LocalOverscrollConfiguration
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.paddingFrom
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.text.selection.LocalTextSelectionColors
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.LocalMinimumTouchTargetEnforcement
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.ProvideTextStyle
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.material.Card
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.InternalComposeApi
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.NoLiveLiterals
import androidx.compose.runtime.getValue
import androidx.compose.runtime.movableContentOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.FirstBaseline
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalFontFamilyResolver
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.LocalTextToolbar
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat
import androidx.databinding.DataBindingUtil
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint
import kotlin.math.roundToInt
import kotlinx.coroutines.launch
import land.sungbin.androidplayground.R
import land.sungbin.androidplayground.composable.SortedColumn
import land.sungbin.androidplayground.composable.SortedLazyColumn
import land.sungbin.androidplayground.constant.DisplayFor
import land.sungbin.androidplayground.databinding.ActivityMainBinding
import land.sungbin.androidplayground.texttoolbar.SungbinLandTextToolbar
import land.sungbin.androidplayground.theme.BackgroundWhite
import land.sungbin.androidplayground.theme.NanumGothicTextStyle
import land.sungbin.androidplayground.theme.NanumGothic
import land.sungbin.androidplayground.theme.Pink
import land.sungbin.androidplayground.theme.PinkOverscrollConfiguration
import land.sungbin.androidplayground.theme.PinkRippleTheme
import land.sungbin.androidplayground.theme.PinkTextSelectionColors
import land.sungbin.androidplayground.viewmodel.MainViewModel
import land.sungbin.androidplayground.wrapper.rememberToast

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
                // Creates a transition state with an initial state where visible = false
                val visibleState = remember { MutableTransitionState(false) }
                // Sets the target state of the transition state to true. As it's different than the initial
                // state, a transition from not visible to visible will be triggered.
                visibleState.targetState = true

                // Creates a transition with the transition state created above.
                val transition = updateTransition(visibleState, label = "")
                // Adds a scale animation to the transition to scale the card up when transitioning in.
                val scale by transition.animateFloat(
                    // Uses a custom spring for the transition.
                    transitionSpec = { spring(dampingRatio = Spring.DampingRatioMediumBouncy) },
                    label = ""
                ) { visible ->
                    if (visible) 1f else 0.8f
                }
                // Adds an elevation animation that animates the dp value of the animation.
                val elevation by transition.animateDp(
                    // Uses a tween animation
                    transitionSpec = {
                        // Uses different animations for when animating from visible to not visible, and
                        // the other way around
                        if (false isTransitioningTo true) {
                            tween(1000)
                        } else {
                            spring()
                        }
                    }, label = ""
                ) { visible ->
                    if (visible) 10.dp else 0.dp
                }

                Card(
                    Modifier
                        .graphicsLayer(scaleX = scale, scaleY = scale)
                        .size(200.dp, 100.dp)
                        .fillMaxWidth()
                        .background(color = Color.Pink),
                    elevation = elevation
                ) {}
            }
        }
    }
}