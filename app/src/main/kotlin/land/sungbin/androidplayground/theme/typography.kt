package land.sungbin.androidplayground.theme

import androidx.compose.material3.LocalTextStyle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import land.sungbin.androidplayground.R

private fun Int.toFontFamily() = FontFamily(Font(this))

val NanumGothic = R.font.nanumgothic.toFontFamily()

val NanumGothicTextStyle
    @ReadOnlyComposable
    @Composable
    get() = LocalTextStyle.current.copy(
        fontFamily = NanumGothic,
        fontSize = 20.sp,
        textAlign = TextAlign.Start
    )