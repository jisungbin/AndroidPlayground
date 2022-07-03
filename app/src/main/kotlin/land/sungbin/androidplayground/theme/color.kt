@file:NoLiveLiterals
@file:Suppress("unused")

package land.sungbin.androidplayground.theme

import androidx.compose.runtime.NoLiveLiterals
import androidx.compose.runtime.Stable
import androidx.compose.ui.graphics.Color

val Color.Companion.BackgroundWhite
    @Stable
    get() = Color(0xFFf4f4f4)

val Color.Companion.Pink
    @Stable
    get() = Color(0xFFFFA9A5)

val Color.Companion.Random
    @Stable
    get() = Color((0..0xFFFFFF).random()) // same 0x000000..0xFFFFFF
