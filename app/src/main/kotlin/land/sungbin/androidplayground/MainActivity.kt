@file:Suppress("MemberVisibilityCanBePrivate")

package land.sungbin.androidplayground

import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily

class MainActivity : ComponentActivity() {
    private var number = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // xml()
        compose()
    }

    fun xml() {
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.btn_state).run {
            setOnClickListener {
                number++
                updateText()
            }
            updateText()
        }
    }

    fun compose() {
        setContent {
            var number by remember { mutableStateOf(0) }

            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Button(onClick = { number++ }) {
                    Text(
                        text = stringResource(
                            R.string.button_number_state,
                            number
                        ),
                        style = LocalTextStyle.current.copy(
                            fontFamily = FontFamily(Font(R.font.nanumgothic))
                        )
                    )
                }
            }
        }
    }

    private fun Button.updateText() {
        text = getString(R.string.button_number_state, number)
    }
}
