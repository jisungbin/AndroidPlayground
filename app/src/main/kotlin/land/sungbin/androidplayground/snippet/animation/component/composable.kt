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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import land.sungbin.androidplayground.snippet.animation.tabTextColor

@Composable
fun TabTitle(
    title: String,
    selectedTabIndex: Int,
    index: Int
) {
    Text(
        text = title,
        style = LocalTextStyle.current.copy(
            color = tabTextColor(
                selectedIndex = selectedTabIndex,
                nowTabIndex = index
            ),
            fontSize = 20.sp,
        )
    )
}

@Composable
fun ColumnScope.TabFullname(selectedTabFullname: String) {
    Text(
        modifier = Modifier.align(Alignment.CenterHorizontally),
        text = selectedTabFullname,
        style = LocalTextStyle.current.copy(
            fontSize = 20.sp,
        )
    )
}

@Composable
fun TabPoster(
    @DrawableRes selectedTabPosterDrawable: Int,
    selectedTabTitle: String
) {
    Image(
        modifier = Modifier.fillMaxSize(),
        painter = painterResource(selectedTabPosterDrawable),
        contentScale = ContentScale.Fit,
        contentDescription = selectedTabTitle
    )
}
