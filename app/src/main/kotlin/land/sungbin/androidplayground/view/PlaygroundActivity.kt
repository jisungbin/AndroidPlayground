@file:Suppress("MayBeConstant")
@file:NoLiveLiterals

package land.sungbin.androidplayground.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.compose.runtime.NoLiveLiterals
import land.sungbin.androidplayground.R

class PlaygroundActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        println("onCreate")
    }

    override fun onStart() {
        super.onStart()
        println("onStart")
    }

    override fun onPause() {
        super.onPause()
        println("onPause")
    }

    override fun onDestroy() {
        super.onDestroy()
        println("onDestroy")
    }
}
