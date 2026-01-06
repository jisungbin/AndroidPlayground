package land.sungbin.androidplayground

import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Suppress("PrivateApi")
class PlaygroundActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    enableEdgeToEdge()
    super.onCreate(savedInstanceState)
    setContent {
      Text(
        modifier = Modifier.padding(50.dp),
        text = getFontSizeResources().contentToString(),
      )
    }
  }

  @Suppress("DiscouragedApi")
  private fun getFontSizeResources(): FloatArray {
    val res = packageManager.getResourcesForApplication(SETTINGS_PACKAGE)
    val resId = res.getIdentifier("entryvalues_font_size", "array", SETTINGS_PACKAGE)
    if (resId == 0) return floatArrayOf()

    val values = res.getStringArray(resId)
    return FloatArray(values.size) { i -> values[i].toFloat() }
  }
}

object FontScaleInspector {

  private const val TAG = "FontScaleInspector"

  // 안드로이드 14 (API 34) 이상은 비선형 스케일링으로 200%까지 지원
  private const val MAX_SCALE_ANDROID_14 = 2.0f

  // 안드로이드 13 이하는 통상적으로 1.3배가 UI 안전 한계선 (Large Text)
  private const val MAX_SCALE_LEGACY = 1.3f

  /**
   * 현재 기기에서 사용자가 설정 앱을 통해 선택할 수 있는 최대 Font Scale 값을 반환한다.
   *
   * 동작 원리:
   * 1. 'com.android.settings' 패키지의 리소스에 접근을 시도한다.
   * 2. 'entryvalues_font_size' 배열을 찾아 파싱한다.
   * 3. 실패 시 OS 버전에 따른 휴리스틱 기본값을 반환한다.
   */
  fun getMaxUserSelectableFontScale(context: Context): Float {
    // 1. 설정 앱 리소스에서 실제 값 추출 시도
    val settingsMax = extractFromSettingsResources(context)
    if (settingsMax != null) {
      Log.i(TAG, "Detected precise max font scale from Settings app: $settingsMax")
      return settingsMax
    }

    // 2. 실패 시 OS 버전에 따른 폴백 값 반환
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.UPSIDE_DOWN_CAKE) {
      Log.i(TAG, "Using Android 14+ standard max scale: $MAX_SCALE_ANDROID_14")
      MAX_SCALE_ANDROID_14
    } else {
      Log.i(TAG, "Using legacy standard max scale: $MAX_SCALE_LEGACY")
      MAX_SCALE_LEGACY
    }
  }

  private fun extractFromSettingsResources(context: Context): Float? {
    val targetPackage = "com.android.settings"

    return try {
      // 다른 패키지(Settings)의 Context를 생성하여 리소스 접근 권한 획득
      val settingsContext = context.createPackageContext(
        targetPackage,
        Context.CONTEXT_IGNORE_SECURITY
      )
      val res = settingsContext.resources

      // AOSP 표준 리소스 이름: entryvalues_font_size
      // 주의: 삼성 등 일부 제조사는 'sec_entryvalues_font_size' 등 다른 이름을 사용할 수 있음
      val resId = res.getIdentifier("entryvalues_font_size", "array", targetPackage)

      if (resId == 0) {
        Log.w(TAG, "Resource 'entryvalues_font_size' not found in $targetPackage")
        return null
      }

      val values = res.getStringArray(resId)

      // 문자열 배열을 Float로 변환하여 최댓값 탐색
      // 예: ["0.85", "1.0", "1.15", "1.30"] -> 1.30 반환
      values.mapNotNull {
        try {
          it.toFloat()
        } catch (e: NumberFormatException) {
          null
        }
      }.maxOrNull()

    } catch (e: PackageManager.NameNotFoundException) {
      Log.w(TAG, "Settings package not found: $targetPackage")
      null
    } catch (e: Exception) {
      Log.e(TAG, "Failed to inspect settings resources", e)
      null
    }
  }
}

private const val SETTINGS_PACKAGE = "com.android.settings"
