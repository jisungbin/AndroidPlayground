@file:NoLiveLiterals
@file:OptIn(ExperimentalAnimationApi::class)

package land.sungbin.androidplayground.snippet.animation

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.ProvideTextStyle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.NoLiveLiterals
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import land.sungbin.androidplayground.annotation.BackgroundPreview
import land.sungbin.androidplayground.snippet.animation.component.MovieContainer
import land.sungbin.androidplayground.snippet.animation.component.MovieName
import land.sungbin.androidplayground.snippet.animation.component.MoviePoster
import land.sungbin.androidplayground.snippet.animation.component.TabContainer
import land.sungbin.androidplayground.snippet.animation.component.TabItem
import land.sungbin.androidplayground.theme.BackgroundWhite
import land.sungbin.androidplayground.theme.NanumGothicTextStyle

@BackgroundPreview
@Composable
fun BasicAnimateStateMovieSelector() {
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
                    TabItem(
                        title = type.string,
                        backgroundColor = tabBackgroundColorWithAnimation(
                            selectedIndex = selectedTabIndexState,
                            nowTabIndex = index
                        ),
                        textColor = tabTextColorWithAnimation(
                            selectedIndex = selectedTabIndexState,
                            nowTabIndex = index
                        ),
                        onTabClick = {
                            selectedTabIndexState = index
                        }
                    )
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

@Composable
private fun tabBackgroundColorWithAnimation(
    selectedIndex: Int,
    nowTabIndex: Int
) = animateColorAsState(
    targetValue = when (selectedIndex == nowTabIndex) {
        true -> TabDefaults.Color.selectedBackground
        false -> TabDefaults.Color.defaultBackground
    },
    animationSpec = defaultTween()
).value

@Composable
private fun tabTextColorWithAnimation(
    selectedIndex: Int,
    nowTabIndex: Int
) = animateColorAsState(
    targetValue = when (selectedIndex == nowTabIndex) {
        true -> TabDefaults.Color.selectedText
        false -> TabDefaults.Color.defaultText
    },
    animationSpec = defaultTween()
).value
