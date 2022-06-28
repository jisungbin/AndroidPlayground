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
    ExperimentalMaterialApi::class,
    ExperimentalComposeUiApi::class,
    ExperimentalFoundationApi::class
)
@file:NoLiveLiterals

package land.sungbin.androidplayground.view

import android.os.Bundle
import android.view.WindowManager
import android.widget.LinearLayout
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.LocalOverscrollConfiguration
import androidx.compose.foundation.OverscrollConfiguration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.selection.LocalTextSelectionColors
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material.Button
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.LocalMinimumTouchTargetEnforcement
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.ProvideTextStyle
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.material.ripple.RippleAlpha
import androidx.compose.material.ripple.RippleTheme
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.InternalComposeApi
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.NoLiveLiterals
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.Snapshot
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.autofill.AutofillType
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.LocalTextToolbar
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import androidx.databinding.DataBindingUtil
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import land.sungbin.androidplayground.R
import land.sungbin.androidplayground.composable.SortedColumn
import land.sungbin.androidplayground.composable.SortedLazyColumn
import land.sungbin.androidplayground.composable.autofill
import land.sungbin.androidplayground.databinding.ActivityMainBinding
import land.sungbin.androidplayground.theme.BackgroundWhite
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
            val textToolbar = LocalTextToolbar.current
            val softwareKeyboardController = LocalSoftwareKeyboardController.current

            var toggleState by remember { mutableStateOf(false) }
            var fieldState by remember { mutableStateOf(TextFieldValue()) }

            LaunchedEffect(Unit) {
                WindowCompat.setDecorFitsSystemWindows(window, false)
                systemUiController.setSystemBarsColor(
                    color = Color.Transparent,
                    darkIcons = true
                )

                window.setFlags( // 네비게이션바까지 영역 확장하려면 필요
                    WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                    WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
                )
            }

            /*SortedColumn {
                ProvideTextStyle(DefaultTextStyle) {
                    TextField(
                        value = fieldState,
                        onValueChange = { field ->
                            fieldState = field
                        }
                    )
                    Button(
                        onClick = {
                            *//*textToolbar.showMenu(
                                rect = Rect.Zero,
                                onCopyRequested = {
                                    println("Copy requested.")
                                },
                                onPasteRequested = {
                                    println("Paste requested.")
                                },
                                onCutRequested = {
                                    println("Cut requested.")
                                },
                                onSelectAllRequested = {
                                    println("Select all requested.")
                                }
                            )*//*
                            softwareKeyboardController?.show()
                        }
                    ) {
                        Text("Show something.")
                    }
                }
            }*/
            ProvideTextStyle(DefaultTextStyle) {
                CompositionLocalProvider(
                    LocalOverscrollConfiguration provides OverscrollConfiguration(
                        glowColor = Color.Red
                    ),
                    LocalRippleTheme provides object : RippleTheme {
                        private val contentColor = Color.Red

                        @Composable
                        override fun defaultColor() = RippleTheme.defaultRippleColor(
                            contentColor = contentColor,
                            lightTheme = true
                        )

                        @Composable
                        override fun rippleAlpha() = RippleTheme.defaultRippleAlpha(
                            contentColor = contentColor,
                            lightTheme = true
                        )
                    },
                    LocalTextSelectionColors provides TextSelectionColors(
                        handleColor = Color.Blue.copy(alpha = 0.2f),
                        backgroundColor = Color.Red.copy(alpha = 0.2f)
                    ),
                ) {
                    SortedLazyColumn(backgroundColor = Color.BackgroundWhite) {
                        items(count = 50) { index ->
                            Button(
                                onClick = { },
                                colors = ButtonDefaults.buttonColors(
                                    backgroundColor = Color.White
                                )
                            ) {
                                SelectionContainer {
                                    Text(text = "This is awesome item in $index index.")
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}