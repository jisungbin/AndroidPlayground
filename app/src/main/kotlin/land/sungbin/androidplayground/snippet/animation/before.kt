package land.sungbin.androidplayground.snippet.animation

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsTopHeight
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.ProvideTextStyle
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import land.sungbin.androidplayground.R
import land.sungbin.androidplayground.extension.and
import land.sungbin.androidplayground.extension.noRippleClickable
import land.sungbin.androidplayground.theme.BackgroundWhite
import land.sungbin.androidplayground.theme.NanumGothicTextStyle
import land.sungbin.androidplayground.theme.Pink

@Immutable
data class TabColors(
    val defaultBackground: Color = Color.White,
    val selectedBackground: Color = Color.Pink,
    val defaultText: Color = Color.Gray,
    val selectedText: Color = Color.Black
)

private object TabDefaults {
    val Items = listOf(
        "토르" to R.drawable.thor_poster and "토르: 러브 앤 썬더",
        "거미맨" to R.drawable.spiderman_poster and "스파이더맨: 노 웨이 홈",
        "의사" to R.drawable.doctor_poster and "닥터 스트레인지: 대혼돈의 멀티버스"
    )
    val Color = TabColors()
}

@Stable
private fun tabBackgroundColor(selectedIndex: Int, nowTabIndex: Int) =
    when (selectedIndex == nowTabIndex) {
        true -> TabDefaults.Color.selectedBackground
        false -> TabDefaults.Color.defaultBackground
    }

@Stable
private fun tabTextColor(selectedIndex: Int, nowTabIndex: Int) =
    when (selectedIndex == nowTabIndex) {
        true -> TabDefaults.Color.selectedText
        false -> TabDefaults.Color.defaultText
    }

@Preview(
    showBackground = true,
    backgroundColor = 0xFFFFFFFF,
    uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_NORMAL
)
@Composable
fun WithoutAnimationDemo() {
    var selectedTabIndex by remember { mutableStateOf(0) }
    val (selectedTabTitle, selectedTabPosterDrawable, selectedTabFullname) = remember(TabDefaults.Items) {
        derivedStateOf {
            TabDefaults.Items[selectedTabIndex]
        }
    }.value

    ProvideTextStyle(NanumGothicTextStyle) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.BackgroundWhite),
            verticalArrangement = Arrangement.spacedBy(30.dp)
        ) {
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .clip(
                        RoundedCornerShape(
                            bottomStart = 30.dp,
                            bottomEnd = 30.dp
                        )
                    ),
                elevation = 10.dp
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                ) {
                    TabDefaults.Items.forEachIndexed { index, (title, _, _) ->
                        Column(
                            modifier = Modifier
                                .weight(1f)
                                .wrapContentHeight()
                                .background(
                                    color = tabBackgroundColor(
                                        selectedIndex = selectedTabIndex,
                                        nowTabIndex = index
                                    )
                                )
                                .noRippleClickable {
                                    selectedTabIndex = index
                                }
                        ) {
                            Spacer(
                                modifier = Modifier
                                    .windowInsetsTopHeight(WindowInsets.systemBars)
                            )
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(50.dp),
                                contentAlignment = Alignment.Center
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
                        }
                    }
                }
            }
            Text(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                text = selectedTabFullname,
            )
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(selectedTabPosterDrawable),
                contentScale = ContentScale.Fit,
                contentDescription = selectedTabTitle
            )
        }
    }
}
