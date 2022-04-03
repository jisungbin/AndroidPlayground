package land.sungbin.androidplayground

import android.graphics.Color
import android.os.Bundle
import android.view.animation.OvershootInterpolator
import androidx.activity.ComponentActivity
import androidx.databinding.DataBindingUtil
import github.hongbeomi.library.Cloudy
import land.sungbin.androidplayground.databinding.ActivityMainBinding

class MainActivity : ComponentActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.tvToast.text = getString(R.string.app_name)
        binding.tvToast.setTextColor(Color.YELLOW)
        // binding.cvSnackbarContainer.setCardBackgroundColor(Color.GRAY)

        binding.btnAnimate.setOnClickListener {
            binding.cvSnackbarContainer.animate().run {
                translationY(-300f)
                interpolator = OvershootInterpolator()
                duration = 1000L
                withLayer()
                start()
            }
            Cloudy.with(this) // context
                .from(binding.root, true)
                // .color(Color.parseColor("#50ffffff"))
                .radius(200f)
                .into(binding.cvSnackbarContainer)
                .blur()
        }
    }
}
