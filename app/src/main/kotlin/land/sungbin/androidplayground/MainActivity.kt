package land.sungbin.androidplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    fun xml() {
        // class RoundImageView(context: Context, attrs: AttributeSet?) : AppCompatImageView(context, attrs)
        setContentView(R.layout.activity_main)
    }

    fun compose() {
        setContent {
            Image(
                modifier = Modifier.clip(RoundedCornerShape(percent = 10)),
                painter = painterResource(R.drawable.little_zerry),
                contentDescription = "zerry"
            )
        }
    }
}