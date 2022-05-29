@file:Suppress("MemberVisibilityCanBePrivate")

package land.sungbin.androidplayground

import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext

class ToastWrapper(context: Context) {
    private val instance = Toast(context)

    operator fun invoke(
        message: String,
        length: Int = Toast.LENGTH_SHORT
    ) {
        show(
            message = message,
            length = length
        )
    }

    fun show(
        message: String,
        length: Int = Toast.LENGTH_SHORT
    ) {
        instance.run {
            setText(message)
            duration = length
            show()
        }
    }

    companion object
}

@Composable
fun rememberToast(): ToastWrapper {
    val context = LocalContext.current.applicationContext
    return remember(context) {
        ToastWrapper(context)
    }
}