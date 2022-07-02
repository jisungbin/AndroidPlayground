package land.sungbin.androidplayground.snippet.animation.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import land.sungbin.androidplayground.snippet.animation.DefaultCornerPercent
import land.sungbin.androidplayground.snippet.animation.tabTextColor

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
                    bottomStartPercent = DefaultCornerPercent,
                    bottomEndPercent = DefaultCornerPercent
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
fun TabTitle(
    modifier: Modifier = Modifier,
    title: String,
    selectedTabIndex: Int,
    index: Int,
    textColor: Color = tabTextColor(
        selectedIndex = selectedTabIndex,
        nowTabIndex = index
    ),
) {
    Text(
        modifier = modifier,
        text = title,
        style = LocalTextStyle.current.copy(
            color = textColor,
            fontSize = 20.sp,
        )
    )
}

@Composable
fun TabTitle(
    modifier: Modifier = Modifier,
    title: String,
    textColor: Color
) {
    TabTitle(
        modifier = modifier,
        title = title,
        selectedTabIndex = 0,
        index = 0,
        textColor = textColor
    )
}
