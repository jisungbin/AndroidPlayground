package land.sungbin.androidplayground.snippet.animation.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import land.sungbin.androidplayground.snippet.animation.tabTextColor

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

@Composable
fun ColumnScope.TabFullname(
    modifier: Modifier = Modifier,
    selectedTabFullname: String
) {
    Text(
        modifier = modifier.align(Alignment.CenterHorizontally),
        text = selectedTabFullname,
        style = LocalTextStyle.current.copy(
            fontSize = 15.sp,
        )
    )
}

@Composable
fun MoviePoster(
    modifier: Modifier = Modifier,
    @DrawableRes selectedTabPosterDrawable: Int,
    posterDescription: String? = null
) {
    Image(
        modifier = modifier.fillMaxSize(),
        painter = painterResource(selectedTabPosterDrawable),
        contentScale = ContentScale.Fit,
        contentDescription = posterDescription
    )
}
