@file:OptIn(ExperimentalAnimationApi::class)

package land.sungbin.androidplayground.snippet.animation

import android.content.res.Configuration
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
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
fun BasicAnimatableMovieSelector() {
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
                                color = tabBackgroundColorWithAnimation(
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
                            textColor = tabTextColorWithAnimation(
                                selectedIndex = selectedTabIndexState,
                                nowTabIndex = index
                            )
                        )
                    }
                }
            }

            MovieContainer {
                AnimatedContent(
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(horizontal = 30.dp),
                    targetState = selectedTabFullname
                ) { targetTabFullname ->
                    MovieName(selectedTabFullname = targetTabFullname)
                }

                AnimatedContent(
                    modifier = Modifier.wrapContentSize(),
                    targetState = selectedTabPosterDrawable,
                    contentAlignment = Alignment.Center
                ) { targetTabPosterDrawable ->
                    MoviePoster(
                        selectedTabPosterDrawable = targetTabPosterDrawable,
                        posterDescription = selectedTabType.string
                    )
                }
            }
        }
    }
}
