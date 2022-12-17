@file:NoLiveLiterals

package land.sungbin.androidplayground.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.CompositionLocal
import androidx.compose.runtime.NoLiveLiterals
import androidx.compose.runtime.State
import androidx.compose.runtime.currentCompositionLocalContext

class PlaygroundActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            @Suppress("UNCHECKED_CAST")
            val localContextLocals =
                currentCompositionLocalContext.javaClass.getDeclaredField("compositionLocals").run {
                    isAccessible = true
                    get(currentCompositionLocalContext)
                } as AbstractMap<CompositionLocal<Any?>, State<Any?>>

            localContextLocals.forEach { (local, state) ->
                println("local: ${local.toString().substringAfterLast(".")}, state: ${state.value}")
            }
        }
    }
}
