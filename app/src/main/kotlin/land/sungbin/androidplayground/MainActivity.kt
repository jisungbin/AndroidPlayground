package land.sungbin.androidplayground

import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {
    private var number = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.btn_state).run {
            setOnClickListener {
                number++
                updateText()
            }
            updateText()
        }
    }

    private fun Button.updateText() {
        text = getString(R.string.button_number_state, number)
    }
}
