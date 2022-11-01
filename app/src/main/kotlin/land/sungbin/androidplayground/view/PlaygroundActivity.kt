@file:Suppress("MayBeConstant")
@file:NoLiveLiterals

package land.sungbin.androidplayground.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.NoLiveLiterals

class PlaygroundActivity : AppCompatActivity() {

    private val vm: AwesomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        println("create")
        super.onCreate(savedInstanceState)
    }

    override fun onDestroy() {
        println("destroy")
        super.onDestroy()
    }
}
