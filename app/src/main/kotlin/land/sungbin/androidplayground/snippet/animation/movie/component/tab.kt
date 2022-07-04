@file:NoLiveLiterals

package land.sungbin.androidplayground.snippet.animation.movie.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.NoLiveLiterals
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import land.sungbin.androidplayground.extension.StatusBarHeightDp
import land.sungbin.androidplayground.extension.noRippleClickable
import land.sungbin.androidplayground.snippet.animation.movie.DefaultCornerUnit

@Composable
fun TabContainer(
    modifier: Modifier = Modifier,
    content: @Composable RowScope.() -> Unit
) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .clip(
                RoundedCornerShape(
                    bottomStartPercent = DefaultCornerUnit,
                    bottomEndPercent = DefaultCornerUnit
                )
            ),
        elevation = 10.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            content = content
        )
    }
}

@Composable
fun RowScope.TabItem(
    modifier: Modifier = Modifier,
    title: String,
    backgroundColor: Color,
    textColor: Color,
    onTabClick: () -> Unit
) {
    Box(
        modifier = modifier
            .weight(1f)
            .height(StatusBarHeightDp + 50.dp)
            .background(color = backgroundColor)
            .noRippleClickable(onClick = onTabClick),
        contentAlignment = Alignment.Center
    ) {
        Text(
            modifier = Modifier.padding(top = StatusBarHeightDp),
            text = title,
            style = LocalTextStyle.current.copy(
                color = textColor,
                fontSize = 20.sp
            )
        )
    }
}
