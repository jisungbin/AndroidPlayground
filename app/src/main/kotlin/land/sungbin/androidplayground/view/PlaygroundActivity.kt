@file:Suppress("MayBeConstant")
@file:NoLiveLiterals

package land.sungbin.androidplayground.view

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.NoLiveLiterals
import team.duckie.quackquack.ui.component.QuackLargeButton

class PlaygroundActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QuackLargeButton(
                text = "Hello, World!",
            ) {
                startActivity(
                    /* intent = */
                    Intent(
                        /* packageContext = */
                        this,
                        /* cls = */
                        PlaygroundActivity::class.java,
                    ),
                )
            }
        }
    }
}