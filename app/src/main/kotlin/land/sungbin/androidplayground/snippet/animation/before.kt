package land.sungbin.androidplayground.snippet.animation

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ProvideTextStyle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import land.sungbin.androidplayground.extension.StatusBarHeightDp
import land.sungbin.androidplayground.extension.noRippleClickable
import land.sungbin.androidplayground.snippet.animation.component.MovieContainer
import land.sungbin.androidplayground.snippet.animation.component.MovieName
import land.sungbin.androidplayground.snippet.animation.component.MoviePoster
import land.sungbin.androidplayground.snippet.animation.component.TabContainer
import land.sungbin.androidplayground.snippet.animation.component.TabTitle
import land.sungbin.androidplayground.theme.BackgroundWhite
import land.sungbin.androidplayground.theme.NanumGothicTextStyle

@Preview(
    showBackground = true,
    backgroundColor = 0xFFFFFFFF,
    uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_NORMAL
)
@Composable
fun WithoutAnimationDemo() {
    var selectedTabIndexState by remember { mutableStateOf(0) }
    val (selectedTabType, selectedTabPosterDrawable, selectedTabFullname) = remember(TabDefaults.Items) {
        derivedStateOf {
            TabDefaults.Items[selectedTabIndexState]
        }
    }.value

    ProvideTextStyle(NanumGothicTextStyle) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.BackgroundWhite),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            TabContainer {
                TabDefaults.Items.forEachIndexed { index, (type, _, _) ->
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .height(StatusBarHeightDp + 50.dp)
                            .background(
                                color = tabBackgroundColor(
                                    selectedIndex = selectedTabIndexState,
                                    nowTabIndex = index
                                )
                            )
                            .noRippleClickable {
                                selectedTabIndexState = index
                            },
                        contentAlignment = Alignment.Center
                    ) {
                        TabTitle(
                            modifier = Modifier.padding(top = StatusBarHeightDp),
                            title = type.string,
                            selectedTabIndex = selectedTabIndexState,
                            index = index
                        )
                    }
                }
            }

            MovieContainer {
                MovieName(selectedTabFullname = selectedTabFullname)
                MoviePoster(
                    selectedTabPosterDrawable = selectedTabPosterDrawable,
                    posterDescription = selectedTabType.string
                )
            }
        }
    }
}
