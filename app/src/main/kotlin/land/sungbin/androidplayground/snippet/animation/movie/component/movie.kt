@file:NoLiveLiterals

package land.sungbin.androidplayground.snippet.animation.movie.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.NoLiveLiterals
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import land.sungbin.androidplayground.extension.runIf
import land.sungbin.androidplayground.snippet.animation.movie.DefaultCornerUnit

@Composable
fun MovieContainer(
    modifier: Modifier = Modifier,
    content: @Composable ColumnScope.() -> Unit
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(600.dp),
        shape = RoundedCornerShape(
            topStart = DefaultCornerUnit.dp,
            topEnd = DefaultCornerUnit.dp
        ),
        elevation = 10.dp,
        backgroundColor = Color.White,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(15.dp),
            content = content
        )
    }
}

@Composable
fun ColumnScope.MovieName(
    modifier: Modifier = Modifier,
    selectedTabFullname: String
) {
    Text(
        modifier = modifier.align(Alignment.CenterHorizontally),
        text = selectedTabFullname,
        style = LocalTextStyle.current.copy(fontSize = 15.sp)
    )
}

@Composable
fun MoviePoster(
    modifier: Modifier = Modifier,
    fillMaxSize: Boolean = true,
    @DrawableRes posterDrawable: Int,
    posterDescription: String? = null
) {
    Image(
        modifier = modifier.runIf(fillMaxSize) { fillMaxSize() },
        painter = painterResource(posterDrawable),
        contentScale = ContentScale.Fit,
        contentDescription = posterDescription
    )
}
