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
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.LocalOverscrollConfiguration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.text.selection.LocalTextSelectionColors
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.InternalComposeApi
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.NoLiveLiterals
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalFontFamilyResolver
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.LocalTextToolbar
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import androidx.databinding.DataBindingUtil
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint
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
            val toast = rememberToast()
            val systemUiController = rememberSystemUiController()

            val view = LocalView.current
            val density = LocalDensity.current
            val uriHandler = LocalUriHandler.current
            val textToolbar = LocalTextToolbar.current
            val focusManager = LocalFocusManager.current
            val fontFamilyResolver = LocalFontFamilyResolver.current
            val softwareKeyboardController = LocalSoftwareKeyboardController.current

            val focusRequesters = List(4) { FocusRequester() }

            val fieldStates = List(4) {
                remember { mutableStateOf(TextFieldValue()) }
            }

            LaunchedEffect(Unit) {
                launch {
                    fontFamilyResolver.preload(NanumGothic)
                }

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

            CompositionLocalProvider(
                LocalRippleTheme provides PinkRippleTheme,
                LocalTextStyle provides NanumGothicTextStyle,
                LocalTextToolbar provides SungbinLandTextToolbar(view),
                LocalTextSelectionColors provides PinkTextSelectionColors,
                LocalOverscrollConfiguration provides PinkOverscrollConfiguration,
            ) {
                SortedLazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = Color.BackgroundWhite)
                ) {
                    items(
                        count = 6,
                        key = { index -> index }
                    ) { index ->
                        val displayFor = remember(index) {
                            when (index) {
                                0 -> DisplayFor.FocusManager // focusManager.moveFocus(Up and Down)
                                in 1..3 -> DisplayFor.FocusRequester // focusRequesters[index].requestFocus()
                                4 -> DisplayFor.OpenSungbinLand // uriHandler.openUri("https://sungbin.land")
                                5 -> DisplayFor.Spacing // Make scrollable column with spacing
                                else -> throw IndexOutOfBoundsException(
                                    "Max index is 5, but your index is $index"
                                )
                            }
                        }

                        when (displayFor) {
                            DisplayFor.FocusRequester -> {
                                SortedColumn(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .wrapContentHeight(),
                                    space = 4.dp
                                ) {
                                    Button(
                                        onClick = {
                                            focusRequesters[index].requestFocus()
                                        },
                                        colors = ButtonDefaults.buttonColors(
                                            backgroundColor = Color.White
                                        )
                                    ) {
                                        Text(text = "${index}번째 TextField 로 포커스 요청")
                                    }
                                    OutlinedTextField(
                                        modifier = Modifier
                                            .focusRequester(focusRequesters[index]),
                                        value = fieldStates[index].value,
                                        onValueChange = { field ->
                                            fieldStates[index].value = field
                                        },
                                        placeholder = {
                                            Text(text = "${index}번째 TextField")
                                        },
                                        singleLine = true,
                                        maxLines = 1,
                                        colors = TextFieldDefaults.outlinedTextFieldColors(
                                            focusedBorderColor = Color.Pink,
                                            cursorColor = Color.Pink
                                        )
                                    )
                                }
                            }
                            DisplayFor.FocusManager -> {
                                SortedColumn(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .wrapContentHeight(),
                                    space = 4.dp
                                ) {
                                    listOf(
                                        FocusDirection.Up to "위",
                                        FocusDirection.Down to "아래"
                                    ).forEach { (focusDirection, label) ->
                                        Button(
                                            onClick = {
                                                focusManager.moveFocus(focusDirection)
                                            },
                                            colors = ButtonDefaults.buttonColors(
                                                backgroundColor = Color.White
                                            )
                                        ) {
                                            Text(text = "${label}에 있는 TextField 로 포커스 이동")
                                        }
                                    }
                                }
                            }
                            DisplayFor.OpenSungbinLand -> {
                                Button(
                                    onClick = {
                                        uriHandler.openUri("https://sungbin.land")
                                    },
                                    colors = ButtonDefaults.buttonColors(
                                        backgroundColor = Color.White
                                    )
                                ) {
                                    Text(text = "성빈랜드 방문")
                                }
                            }
                            DisplayFor.Spacing -> Spacer(modifier = Modifier.height(500.dp))
                        }
                    }
                }
            }
        }
    }
}