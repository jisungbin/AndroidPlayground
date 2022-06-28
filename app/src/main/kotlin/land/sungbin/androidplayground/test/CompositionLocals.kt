package land.sungbin.androidplayground.test

import androidx.activity.compose.LocalActivityResultRegistryOwner
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.LocalOverscrollConfiguration
import androidx.compose.foundation.lazy.layout.ModifierLocalPinnableParent
import androidx.compose.foundation.text.selection.LocalTextSelectionColors
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.LocalAbsoluteElevation
import androidx.compose.material.LocalContentColor
import androidx.compose.material.LocalElevationOverlay
import androidx.compose.material.LocalMinimumTouchTargetEnforcement
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.runtime.saveable.LocalSaveableStateRegistry
import androidx.compose.runtime.tooling.LocalInspectionTables
import androidx.compose.ui.ExperimentalComposeUiApi
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

@OptIn(
    ExperimentalMaterialApi::class,
    ExperimentalFoundationApi::class,
    ExperimentalComposeUiApi::class
)
fun main() = setContent {
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

    /** 잘 알려지지 않은 것들, 알아두면 좋을 것들, 중요한 것들 */
    LocalMinimumTouchTargetEnforcement // 최소 터치 영역 조정
    LocalDensity // Density 제공, 단 중요하게 쓰임
    LocalFocusManager // FocusManager 제공, 단 중요하게 쓰임
    LocalFontFamilyResolver // FontFamily.Resolver 제공, 파악 필요
    LocalHapticFeedback // HapticFeedback 제공, 단 중요하게 쓰임
    LocalInspectionMode // 안드로이드 스튜디오 Preview 로 보이고 있는지 Boolean 값 제공
    LocalTextToolbar // TextToolbar 제공, 유용하게 쓰일 수 있음
    LocalSoftwareKeyboardController // SoftwareKeyboardController 제공, 키보드 visible 컨트롤 가능
    LocalOverscrollConfiguration // OverScroll Effect 커스텀에 쓰임
    LocalRippleTheme
    LocalTextSelectionColors
    LocalActivityResultRegistryOwner
    LocalOnBackPressedDispatcherOwner

    /** 왜 존재하는지 모르겠는 것들 */
    LocalUriHandler // 그냥 Action.VIEW 로 startActivity
    /**
    class AndroidUriHandler(private val context: Context) : UriHandler {
    override fun openUri(uri: String) {
    context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(uri)))
    }
    }
     */


}