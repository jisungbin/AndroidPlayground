package land.sungbin.androidplayground.snippet.animation.preview

import androidx.compose.ui.tooling.preview.PreviewParameterProvider

class BooleanPreview : PreviewParameterProvider<Boolean> {
    override val values = sequenceOf(true, false)
}
