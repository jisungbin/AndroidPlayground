package land.sungbin.androidplayground

import android.content.Context
import android.content.res.Resources
import android.graphics.Canvas
import android.graphics.Path
import android.graphics.RectF
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView

    class RoundImageView(context: Context, attrs: AttributeSet?) : AppCompatImageView(context, attrs) {
        private var clipPath: Path? = null
        private var imageRadius = 16.dp
        private var bitmapRect: RectF? = null

        init {
            clipPath = Path()
            val typedArray = context.obtainStyledAttributes(
                attrs,
                R.styleable.RoundImageView,
                0,
                0
            )
            imageRadius = typedArray.getDimensionPixelSize(
                R.styleable.RoundImageView_riv_radius,
                this.imageRadius
            )
            typedArray.recycle()
        }

        override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
            super.onSizeChanged(w, h, oldw, oldh)
            bitmapRect = RectF(0f, 0f, w.toFloat(), h.toFloat())
        }

        override fun draw(canvas: Canvas) {
            val clipPath = checkNotNull(clipPath) {
                "clipPath is not initialized"
            }
            clipPath.reset()
            clipPath.addRoundRect(
                bitmapRect!!,
                imageRadius.toFloat(),
                imageRadius.toFloat(),
                Path.Direction.CW
            )
            canvas.clipPath(clipPath)
            super.draw(canvas)
        }

        private val Int.dp: Int
            get() {
                val scale = Resources.getSystem().displayMetrics.density
                return (this * scale + 0.5f).toInt()
            }
    }