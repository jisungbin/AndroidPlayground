@file:OptIn(
    ExperimentalMaterialApi::class,
    ExperimentalFoundationApi::class,
    ExperimentalComposeUiApi::class
)
@file:Suppress(
    "FunctionName",
    "unused",
    "UNUSED_VARIABLE"
)

package land.sungbin.androidplayground.note

import androidx.activity.ComponentActivity
import androidx.activity.compose.LocalActivityResultRegistryOwner
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.LocalOverscrollConfiguration
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.text.selection.LocalTextSelectionColors
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.LocalAbsoluteElevation
import androidx.compose.material.LocalContentColor
import androidx.compose.material.LocalElevationOverlay
import androidx.compose.material.LocalMinimumTouchTargetEnforcement
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.LocalSaveableStateRegistry
import androidx.compose.runtime.tooling.LocalInspectionTables
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalAccessibilityManager
import androidx.compose.ui.platform.LocalAutofill
import androidx.compose.ui.platform.LocalAutofillTree
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalFontFamilyResolver
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.platform.LocalInputModeManager
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.platform.LocalSavedStateRegistryOwner
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.LocalTextInputService
import androidx.compose.ui.platform.LocalTextToolbar
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.platform.LocalViewConfiguration
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import kotlinx.coroutines.launch
import land.sungbin.androidplayground.composable.SortedColumn
import land.sungbin.androidplayground.composable.SortedLazyColumn
import land.sungbin.androidplayground.constant.DisplayFor
import land.sungbin.androidplayground.setContent
import land.sungbin.androidplayground.texttoolbar.SungbinLandTextToolbar
import land.sungbin.androidplayground.theme.BackgroundWhite
import land.sungbin.androidplayground.theme.NanumGothic
import land.sungbin.androidplayground.theme.NanumGothicTextStyle
import land.sungbin.androidplayground.theme.Pink
import land.sungbin.androidplayground.theme.PinkOverscrollConfiguration
import land.sungbin.androidplayground.theme.PinkRippleTheme
import land.sungbin.androidplayground.theme.PinkTextSelectionColors
import land.sungbin.androidplayground.wrapper.rememberToast

fun LocalCompositionList() = setContent {
    /** 그냥 값 제공만 하는 것들 or 덜 중요한 것들 */
    LocalContext // context 제공
    LocalAccessibilityManager // AccessibilityManager 제공
    LocalAutofill // Autofill 제공
    LocalAutofillTree // Autofill 에 사용할 AutofillTree 제공
    LocalTextStyle // TextStyle 제공
    LocalContentColor // ContentColor 제공
    LocalLifecycleOwner // LifecycleOwner 제공
    LocalElevationOverlay // ElevationOverlay 제공
    LocalAbsoluteElevation // AbsoluteElevation 제공
    LocalClipboardManager // ClipboardManager 제공
    LocalConfiguration // Configuration 제공
    LocalInputModeManager // InputModeManager 제공, 근데 안드로이드에선 쓸모 없어 보임
    LocalLayoutDirection // LayoutDirection 제공
    LocalSavedStateRegistryOwner // SavedStateRegistryOwner 제공, 직접적으로 쓸 일 없음
    LocalSaveableStateRegistry // SaveableStateRegistry 제공, 직접적으로 쓸 일 없음
    LocalTextInputService // TextInputService 제공
    LocalView // Owner 제공
    LocalViewConfiguration // ViewConfiguration 제공
    LocalWindowInfo // 현재 컴포저블을 호스팅 하는 윈도우가 visible 상태인지 Boolean 값 제공, 쓸 일이 많지는 않을거 같음
    LocalIndication // 커스텀하기 너무 어려움
    LocalInspectionTables // 보통 개발 환경에선 쓸 일 없음
    LocalHapticFeedback // HapticFeedback 제공
    LocalOnBackPressedDispatcherOwner // BackHandler 로 사용함
    LocalActivityResultRegistryOwner // registerForActivityResult 용도로만 사용함

    /** 잘 알려지지 않은 것들, 알아두면 좋을 것들, 중요한 것들 */
    LocalMinimumTouchTargetEnforcement // 컴포저블 사이즈를 최소 터치 영역에 맞게 조정, 디자인에 영향 미칠 수 있음
    LocalDensity // Density 제공, 단위 변환에 유용하게 쓰임
    LocalFocusManager // FocusManager 제공, TextField 포커싱 제어에 유용하게 쓰임
    LocalFontFamilyResolver // FontFamily.Resolver 제공, FontFamily 캐시 가능
    LocalInspectionMode // 안드로이드 스튜디오 Preview 로 보이고 있는지 Boolean 값 제공
    LocalTextToolbar // TextToolbar 제공, TextField 에 적용할 ActionMode 를 제공함
    LocalSoftwareKeyboardController // SoftwareKeyboardController 제공, 키보드 visible 컨트롤 가능
    LocalOverscrollConfiguration // OverScroll Effect 커스터마이징
    LocalRippleTheme // Ripple Theme 커스터마이징
    LocalTextSelectionColors // TextSelection color 커스터마이징

    /** 왜 존재하는지 모르겠는 것들 */
    LocalUriHandler // 그냥 Action.VIEW 로 startActivity 해줌
}

fun ComponentActivity.CompositionLocals() = setContent {
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
        LocalMinimumTouchTargetEnforcement provides true,
        LocalTextToolbar provides SungbinLandTextToolbar(view),
        LocalTextSelectionColors provides PinkTextSelectionColors,
        LocalOverscrollConfiguration provides PinkOverscrollConfiguration,
    ) {
        SortedLazyColumn(
            backgroundColor = Color.BackgroundWhite
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
                        5 -> DisplayFor.Spacing // Make scrollable LazyColumn with spacing
                        else -> throw IndexOutOfBoundsException("Max index is 5, but your index is $index")
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
