@file:Suppress(
    "MemberVisibilityCanBePrivate",
    "SetTextI18n"
)

package land.sungbin.androidplayground

import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

class MainActivity : ComponentActivity() {
    private var number = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        xml()
    }

    fun xml() {
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.btn_state).run {
            setOnClickListener {
                number++
                text = "increase number: $number"
            }
            text = "increase number: $number"
        }
    }

    fun compose() {
        setContent {
            var number by remember { mutableStateOf(0) }
            Button(onClick = { number++ }) {
                Text(text = "increase number: $number")
            }
        }
    }
}
