@file:NoLiveLiterals
@file:OptIn(ExperimentalAnimationApi::class, ExperimentalTransitionApi::class)

package land.sungbin.androidplayground.snippet.animation.movie

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.SizeTransform
import androidx.compose.animation.animateColor
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.AnimationVector4D
import androidx.compose.animation.core.ExperimentalTransitionApi
import androidx.compose.animation.core.Transition
import androidx.compose.animation.core.TwoWayConverter
import androidx.compose.animation.core.animateIntOffset
import androidx.compose.animation.core.animateValue
import androidx.compose.animation.core.createChildTransition
import androidx.compose.animation.core.updateTransition
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.with
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ProvideTextStyle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.NoLiveLiterals
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
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import land.sungbin.androidplayground.annotation.BackgroundPreview
import land.sungbin.androidplayground.extension.StatusBarHeightDp
import land.sungbin.androidplayground.extension.toPercent
import land.sungbin.androidplayground.snippet.animation.movie.component.MovieContainer
import land.sungbin.androidplayground.snippet.animation.movie.component.MovieName
import land.sungbin.androidplayground.snippet.animation.movie.component.MoviePoster
import land.sungbin.androidplayground.snippet.animation.movie.component.TabContainer
import land.sungbin.androidplayground.snippet.animation.movie.component.TabItem
import land.sungbin.androidplayground.theme.BackgroundWhite
import land.sungbin.androidplayground.theme.NanumGothicTextStyle

@Composable
private fun MovieTab(
    selectedTabTransition: Transition<Movie>,
    updateSelectedTabType: (type: Movie) -> Unit,
) {
    BoxWithConstraints(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .clip(
                RoundedCornerShape(
                    bottomStartPercent = DefaultCornerUnit,
                    bottomEndPercent = DefaultCornerUnit
                )
            )
    ) {
        val eachItemWidth = remember { maxWidth / TabDefaults.Items.count() }
        val backgroundOffsetTransition by selectedTabTransition.animateIntOffset(
            transitionSpec = { defaultTween() },
            label = "background offset"
        ) { selectedTabType ->
            IntOffset(
                x = with(LocalDensity.current) {
                    (eachItemWidth * selectedTabType.ordinal).toPx()
                }.toInt(),
                y = 0
            )
        }
        val backgroundShapeTransition by selectedTabTransition.animateValue(
            transitionSpec = { defaultTween() },
            label = "background shape",
            typeConverter = TwoWayConverter(
                convertToVector = { corner ->
                    AnimationVector4D(
                        v1 = corner.topStart.toPercent(),
                        v2 = corner.topEnd.toPercent(),
                        v3 = corner.bottomStart.toPercent(),
                        v4 = corner.bottomEnd.toPercent()
                    )
                },
                convertFromVector = { vector ->
                    RoundedCornerShape(
                        topStartPercent = vector.v1.toInt(),
                        topEndPercent = vector.v2.toInt(),
                        bottomStartPercent = vector.v3.toInt(),
                        bottomEndPercent = vector.v4.toInt()
                    )
                },
            )
        ) { selectedTabType ->
            when (selectedTabType) {
                Movie.Thor -> RoundedCornerShape(bottomStartPercent = 30)
                Movie.Spider -> RoundedCornerShape(percent = 0)
                Movie.Doctor -> RoundedCornerShape(bottomEndPercent = 30)
            }
        }

        TabContainer {
            TabDefaults.Items.forEach { (type, _, _) ->
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
                    backgroundColor = TabDefaults.Color.defaultBackground,
                    textColor = textColor,
                    onTabClick = {
                        updateSelectedTabType(type)
                    }
                )
            }
        }

        Box(
            modifier = Modifier
                .width(eachItemWidth)
                .height(StatusBarHeightDp + 50.dp)
                .offset { backgroundOffsetTransition }
                .clip(backgroundShapeTransition)
                .background(color = TabDefaults.Color.selectedBackground)
        )
    }
}

@BackgroundPreview
@Composable
fun MovieSelectorBasic() {
    var selectedTabTypeState by remember { mutableStateOf(Movie.Thor) }
    val (selectedTabType, selectedTabPosterDrawable, selectedTabFullname) = remember(TabDefaults.Items) {
        derivedStateOf {
            TabDefaults.Items[selectedTabTypeState.ordinal]
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
                TabDefaults.Items.forEach { (type, _, _) ->
                    TabItem(
                        title = type.string,
                        backgroundColor = tabBackgroundColor(
                            selectedTabType = selectedTabTypeState,
                            nowTabType = type
                        ),
                        textColor = tabTextColor(
                            selectedTabType = selectedTabTypeState,
                            nowTabType = type
                        ),
                        onTabClick = {
                            selectedTabTypeState = type
                        }
                    )
                }
            }
            MovieContainer {
                MovieName(selectedTabFullname = selectedTabFullname)
                MoviePoster(
                    posterDrawable = selectedTabPosterDrawable,
                    posterDescription = selectedTabType.string
                )
            }
        }
    }
}

@BackgroundPreview
@Composable
fun MovieSelectorWithHighLevelAnimated() {
    var selectedTabTypeState by remember { mutableStateOf(Movie.Thor) }
    val (selectedTabType, selectedTabPosterDrawable, selectedTabFullname) = remember(TabDefaults.Items) {
        derivedStateOf {
            TabDefaults.Items[selectedTabTypeState.ordinal]
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
                TabDefaults.Items.forEach { (type, _, _) ->
                    TabItem(
                        title = type.string,
                        backgroundColor = tabBackgroundColorWithAnimation(
                            selectedTab = selectedTabTypeState,
                            nowTab = type
                        ),
                        textColor = tabTextColorWithAnimation(
                            selectedTabType = selectedTabTypeState,
                            nowTabType = type
                        ),
                        onTabClick = {
                            selectedTabTypeState = type
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
                        posterDrawable = targetTabPosterDrawable,
                        posterDescription = selectedTabType.string
                    )
                }
            }
        }
    }
}

@BackgroundPreview
@Composable
fun MovieSelectorWithCustomAnimateSpec() {
    var selectedTabState by remember { mutableStateOf(TabDefaults.Items.first()) }
    val (selectedTabType, selectedTabPosterDrawable, selectedTabFullname) = remember {
        derivedStateOf { selectedTabState }
    }.value

    ProvideTextStyle(NanumGothicTextStyle) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.BackgroundWhite),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            TabContainer {
                TabDefaults.Items.forEach { tab ->
                    val (type, _, _) = tab
                    TabItem(
                        title = type.string,
                        backgroundColor = tabBackgroundColorWithAnimation(
                            selectedTab = selectedTabType,
                            nowTab = type
                        ),
                        textColor = tabTextColorWithAnimation(
                            selectedTabType = selectedTabType,
                            nowTabType = type
                        ),
                        onTabClick = {
                            selectedTabState = tab
                        }
                    )
                }
            }

            MovieContainer {
                AnimatedContent(
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(horizontal = 30.dp),
                    targetState = selectedTabFullname,
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
                ) { selectedTabFullname ->
                    MovieName(selectedTabFullname = selectedTabFullname)
                }

                AnimatedContent(
                    modifier = Modifier.wrapContentSize(),
                    targetState = selectedTabPosterDrawable,
                    contentAlignment = Alignment.Center,
                    transitionSpec = {
                        val targetIndex = TabDefaults.findTabIndexByDrawable(targetState)
                        val initialIndex = TabDefaults.findTabIndexByDrawable(initialState)

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
                ) { targetTabPosterDrawable ->
                    MoviePoster(posterDrawable = targetTabPosterDrawable)
                }
            }
        }
    }
}

@BackgroundPreview
@Composable
fun MovieSelectorWithCustomAnimateSpecAndTransition() {
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
                selectedTabTransition
                    .createChildTransition(label = "selected fab fullname") { selectedTabType ->
                        val (_, _, selectedTabFullname) = TabDefaults.Items[selectedTabType.ordinal]
                        selectedTabFullname
                    }
                    .AnimatedContent(
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
                    ) { selectedTabFullname ->
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
                        posterDrawable = selectedTabPosterDrawable,
                        posterDescription = selectedTabType.string
                    )
                }
            }
        }
    }
}

@BackgroundPreview
@Composable
fun MovieSelectorWithCustomTabTransition() {
    var selectedMovieState by remember { mutableStateOf(Movie.Thor) }
    val selectedTabTransition = updateTransition(
        targetState = selectedMovieState,
        label = "selected tab"
    )

    ProvideTextStyle(NanumGothicTextStyle) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.BackgroundWhite),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            MovieTab(
                selectedTabTransition = selectedTabTransition,
                updateSelectedTabType = { newSelectedTabType ->
                    selectedMovieState = newSelectedTabType
                }
            )

            MovieContainer {
                selectedTabTransition
                    .createChildTransition(label = "selected fab fullname") { selectedTabType ->
                        val (_, _, selectedTabFullname) = TabDefaults.Items[selectedTabType.ordinal]
                        selectedTabFullname
                    }
                    .AnimatedContent(
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
                    ) { selectedTabFullname ->
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
                        posterDrawable = selectedTabPosterDrawable,
                        posterDescription = selectedTabType.string
                    )
                }
            }
        }
    }
}

@Stable
private fun tabBackgroundColor(
    selectedTabType: Movie,
    nowTabType: Movie,
): Color = when (selectedTabType == nowTabType) {
    true -> TabDefaults.Color.selectedBackground
    false -> TabDefaults.Color.defaultBackground
}

@Stable
private fun tabTextColor(
    selectedTabType: Movie,
    nowTabType: Movie,
) = when (selectedTabType == nowTabType) {
    true -> TabDefaults.Color.selectedText
    false -> TabDefaults.Color.defaultText
}

@Composable
private fun tabBackgroundColorWithAnimation(
    selectedTab: Movie,
    nowTab: Movie,
) = animateColorAsState(
    targetValue = when (selectedTab == nowTab) {
        true -> TabDefaults.Color.selectedBackground
        false -> TabDefaults.Color.defaultBackground
    },
    animationSpec = defaultTween()
).value

@Composable
private fun tabTextColorWithAnimation(
    selectedTabType: Movie,
    nowTabType: Movie,
) = animateColorAsState(
    targetValue = when (selectedTabType == nowTabType) {
        true -> TabDefaults.Color.selectedText
        false -> TabDefaults.Color.defaultText
    },
    animationSpec = defaultTween()
).value
