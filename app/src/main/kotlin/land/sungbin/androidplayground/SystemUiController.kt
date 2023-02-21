@file:Suppress("DEPRECATION", "MemberVisibilityCanBePrivate")

package land.sungbin.androidplayground

import android.os.Build
import android.view.View
import android.view.Window
import androidx.annotation.ColorInt

class SystemUiController(private val window: Window) {
    fun setStatusBarColor(color: Int, darkIcons: Boolean) {
        window.statusBarColor = color
        if (darkIcons) {
            window.decorView.systemUiVisibility = window.decorView.systemUiVisibility or
                    View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        } else {
            window.decorView.systemUiVisibility = window.decorView.systemUiVisibility and
                    View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR.inv()
        }
    }

    fun setNavigationBarColor(@ColorInt color: Int, darkIcons: Boolean) {
        window.navigationBarColor = color
        if (Build.VERSION.SDK_INT >= 26) {
            if (darkIcons) {
                window.decorView.systemUiVisibility = window.decorView.systemUiVisibility or
                        View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR
            } else {
                window.decorView.systemUiVisibility = window.decorView.systemUiVisibility and
                        View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR.inv()
            }
        }
    }

    fun setSystemBarsColor(@ColorInt color: Int, darkIcons: Boolean) {
        setStatusBarColor(color, darkIcons)
        setNavigationBarColor(color, darkIcons)
    }
}
