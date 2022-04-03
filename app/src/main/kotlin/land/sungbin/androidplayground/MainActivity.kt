package land.sungbin.androidplayground

import android.graphics.Color
import android.os.Bundle
import android.view.animation.OvershootInterpolator
import androidx.activity.ComponentActivity
import androidx.databinding.DataBindingUtil
import land.sungbin.androidplayground.databinding.ActivityMainBinding

class MainActivity : ComponentActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.tvToast.text = getString(R.string.app_name)
        binding.tvToast.setTextColor(Color.YELLOW)
        binding.cvSnackbarContainer.setCardBackgroundColor(Color.GRAY)
        binding.cvSnackbarContainer.animate().run {
            translationY(-500f)
            interpolator = OvershootInterpolator()
            duration = 1000L
            withLayer()
            start()
        }
    }
}
