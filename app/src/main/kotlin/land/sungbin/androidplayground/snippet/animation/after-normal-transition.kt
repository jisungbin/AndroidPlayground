@file:NoLiveLiterals
@file:OptIn(ExperimentalAnimationApi::class)

package land.sungbin.androidplayground.snippet.animation

import android.content.res.Configuration
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.SizeTransform
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.updateTransition
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.with
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.ProvideTextStyle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.NoLiveLiterals
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
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
fun NormalTransitionMovieSelector() {
    var selectedTabTypeState by remember { mutableStateOf(Movie.Thor) }
    val selectedTabTransition = updateTransition(
        targetState = selectedTabTypeState,
        label = "selected tab"
    )

    ProvideTextStyle(NanumGothicTextStyle) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.BackgroundWhite),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            TabContainer {
                TabDefaults.Items.forEach { (type, _, _) ->
                    val backgroundColor by selectedTabTransition.animateColor(
                        transitionSpec = { defaultTween() },
                        label = "background color"
                    ) { selectedTabType ->
                        when (selectedTabType == type) {
                            true -> TabDefaults.Color.selectedBackground
                            false -> TabDefaults.Color.defaultBackground
                        }
                    }
                    val textColor by selectedTabTransition.animateColor(
                        transitionSpec = { defaultTween() },
                        label = "text color"
                    ) { selectedTabType ->
                        when (selectedTabType == type) {
                            true -> TabDefaults.Color.selectedText
                            false -> TabDefaults.Color.defaultText
                        }
                    }

                    TabItem(
                        title = type.string,
                        backgroundColor = backgroundColor,
                        textColor = textColor,
                        onTabClick = {
                            selectedTabTypeState = type
                        }
                    )
                }
            }

            MovieContainer {
                selectedTabTransition.AnimatedContent(
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(horizontal = 30.dp),
                    transitionSpec = {
                        fadeIn(
                            animationSpec = defaultTween()
                        ) with fadeOut(
                            animationSpec = defaultTween()
                        ) using SizeTransform(
                            clip = false,
                            sizeAnimationSpec = { _, _ ->
                                defaultTween()
                            }
                        )
                    }
                ) { selectedTabType ->
                    val (_, _, selectedTabFullname) = TabDefaults.Items[selectedTabType.ordinal]
                    MovieName(selectedTabFullname = selectedTabFullname)
                }

                selectedTabTransition.AnimatedContent(
                    modifier = Modifier.wrapContentSize(),
                    contentAlignment = Alignment.Center,
                    transitionSpec = {
                        val targetIndex = targetState.ordinal
                        val initialIndex = initialState.ordinal

                        if (targetIndex > initialIndex) { // 다음 탭
                            slideIntoContainer(
                                towards = AnimatedContentScope.SlideDirection.Start,
                                animationSpec = defaultTween(),
                            ) with fadeOut(
                                animationSpec = defaultTween()
                            ) using SizeTransform(
                                clip = false,
                                sizeAnimationSpec = { _, _ ->
                                    defaultTween()
                                }
                            )
                        } else { // 이전 탭
                            fadeIn(
                                animationSpec = defaultTween()
                            ) with slideOutOfContainer(
                                towards = AnimatedContentScope.SlideDirection.End,
                                animationSpec = defaultTween(),
                            ) using SizeTransform(
                                clip = false,
                                sizeAnimationSpec = { _, _ ->
                                    defaultTween()
                                }
                            )
                        }.apply {
                            targetContentZIndex = targetIndex.toFloat()
                        }
                    }
                ) { selectedTabType ->
                    val (_, selectedTabPosterDrawable, _) = TabDefaults.Items[selectedTabType.ordinal]
                    MoviePoster(
                        selectedTabPosterDrawable = selectedTabPosterDrawable,
                        posterDescription = selectedTabType.string
                    )
                }
            }
        }
    }
}
