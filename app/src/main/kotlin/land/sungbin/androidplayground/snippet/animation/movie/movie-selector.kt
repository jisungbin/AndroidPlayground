@file:NoLiveLiterals
@file:OptIn(ExperimentalAnimationApi::class, ExperimentalTransitionApi::class)

package land.sungbin.androidplayground.snippet.animation.movie

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.SizeTransform
import androidx.compose.animation.animateColor
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
    selectedTabTransition: Transition<Tab>,
    updateSelectedTab: (tab: Tab) -> Unit,
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
        ) { tab ->
            IntOffset(
                x = with(LocalDensity.current) {
                    (eachItemWidth * tab.index).toPx()
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
        ) { tab ->
            when (tab.type) {
                Movie.Thor -> RoundedCornerShape(bottomStartPercent = 30)
                Movie.Spider -> RoundedCornerShape(percent = 0)
                Movie.Doctor -> RoundedCornerShape(bottomEndPercent = 30)
            }
        }

        TabContainer {
            TabDefaults.Items.forEach { tab ->
                val textColor by selectedTabTransition.animateColor(
                    transitionSpec = { defaultTween() },
                    label = "text color"
                ) { selectedTab ->
                    when (selectedTab == tab) {
                        true -> TabDefaults.Color.selectedText
                        false -> TabDefaults.Color.defaultText
                    }
                }

                TabItem(
                    title = tab.shortname,
                    backgroundColor = TabDefaults.Color.defaultBackground,
                    textColor = textColor,
                    onTabClick = {
                        updateSelectedTab(tab)
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

// no animation
@BackgroundPreview
@Composable
fun MovieSelectorBasic() {
    var selectedTabState by remember { mutableStateOf(TabDefaults.Items.first()) }

    ProvideTextStyle(NanumGothicTextStyle) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.BackgroundWhite),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            TabContainer {
                TabDefaults.Items.forEach { tab ->
                    TabItem(
                        title = tab.shortname,
                        backgroundColor = tabBackgroundColor(
                            selectedTab = selectedTabState,
                            nowTab = tab
                        ),
                        textColor = tabTextColor(
                            selectedTab = selectedTabState,
                            nowTab = tab
                        ),
                        onTabClick = {
                            selectedTabState = tab
                        }
                    )
                }
            }
            MovieContainer {
                MovieName(selectedTabFullname = selectedTabState.fullname)
                MoviePoster(posterDrawable = selectedTabState.poster)
            }
        }
    }
}

// animateColorAsState, AnimatedContent
@BackgroundPreview
@Composable
fun MovieSelectorWithHighLevelAnimated() {
    var selectedTabState by remember { mutableStateOf(TabDefaults.Items.first()) }

    ProvideTextStyle(NanumGothicTextStyle) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.BackgroundWhite),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            TabContainer {
                TabDefaults.Items.forEach { tab ->
                    TabItem(
                        title = tab.shortname,
                        backgroundColor = tabBackgroundColorWithAnimation(
                            selectedTab = selectedTabState,
                            nowTab = tab
                        ),
                        textColor = tabTextColorWithAnimation(
                            selectedTab = selectedTabState,
                            nowTab = tab
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
                    targetState = selectedTabState
                ) { tab ->
                    MovieName(selectedTabFullname = tab.fullname)
                }

                AnimatedContent(
                    modifier = Modifier.wrapContentSize(),
                    targetState = selectedTabState,
                    contentAlignment = Alignment.Center
                ) { tab ->
                    MoviePoster(posterDrawable = tab.poster)
                }
            }
        }
    }
}

// animateColorAsState, AnimatedContent with custom animation spec
@BackgroundPreview
@Composable
fun MovieSelectorWithCustomAnimateSpec() {
    var selectedTabState by remember { mutableStateOf(TabDefaults.Items.first()) }

    ProvideTextStyle(NanumGothicTextStyle) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.BackgroundWhite),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            TabContainer {
                TabDefaults.Items.forEach { tab ->
                    TabItem(
                        title = tab.shortname,
                        backgroundColor = tabBackgroundColorWithAnimation(
                            selectedTab = selectedTabState,
                            nowTab = tab
                        ),
                        textColor = tabTextColorWithAnimation(
                            selectedTab = selectedTabState,
                            nowTab = tab
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
                    targetState = selectedTabState,
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
                ) { tab ->
                    MovieName(selectedTabFullname = tab.fullname)
                }

                AnimatedContent(
                    modifier = Modifier.wrapContentSize(),
                    targetState = selectedTabState,
                    contentAlignment = Alignment.Center,
                    transitionSpec = {
                        val targetIndex = targetState.index // targetState == Tab
                        val initialIndex = initialState.index // initialState == Tab

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
                ) { tab ->
                    MoviePoster(posterDrawable = tab.poster)
                }
            }
        }
    }
}


// animateColorAsState, AnimatedContent with custom animation spec and transition
@BackgroundPreview
@Composable
fun MovieSelectorWithCustomAnimateSpecAndTransition() {
    var selectedTabState by remember { mutableStateOf(TabDefaults.Items.first()) }
    val selectedTabTransition = updateTransition(
        targetState = selectedTabState,
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
                TabDefaults.Items.forEach { tab ->
                    val backgroundColor by selectedTabTransition.animateColor(
                        transitionSpec = { defaultTween() },
                        label = "background color"
                    ) { selectedTabType ->
                        when (selectedTabType == tab) {
                            true -> TabDefaults.Color.selectedBackground
                            false -> TabDefaults.Color.defaultBackground
                        }
                    }
                    val textColor by selectedTabTransition.animateColor(
                        transitionSpec = { defaultTween() },
                        label = "text color"
                    ) { selectedTabType ->
                        when (selectedTabType == tab) {
                            true -> TabDefaults.Color.selectedText
                            false -> TabDefaults.Color.defaultText
                        }
                    }

                    TabItem(
                        title = tab.shortname,
                        backgroundColor = backgroundColor,
                        textColor = textColor,
                        onTabClick = {
                            selectedTabState = tab
                        }
                    )
                }
            }

            MovieContainer {
                selectedTabTransition
                    .createChildTransition(label = "selected tab fullname") { tab ->
                        tab.fullname
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

                selectedTabTransition
                    .AnimatedContent(
                        modifier = Modifier.wrapContentSize(),
                        contentAlignment = Alignment.Center,
                        transitionSpec = {
                            val targetIndex = targetState.index // targetState == Tab
                            val initialIndex = initialState.index // initialIndex == Tab

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
                    ) { tab ->
                        MoviePoster(posterDrawable = tab.poster)
                    }
            }
        }
    }
}

// animateColorAsState, AnimatedContent with custom animation spec and transition, movie tab
@BackgroundPreview
@Composable
fun MovieSelectorWithCustomTabTransition() {
    var selectedTabState by remember { mutableStateOf(TabDefaults.Items.first()) }
    val selectedTabTransition = updateTransition(
        targetState = selectedTabState,
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
                updateSelectedTab = { newSelectedTab ->
                    selectedTabState = newSelectedTab
                }
            )

            MovieContainer {
                selectedTabTransition
                    .createChildTransition(label = "selected tab fullname") { tab ->
                        tab.fullname
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

                selectedTabTransition
                    .AnimatedContent(
                        modifier = Modifier.wrapContentSize(),
                        contentAlignment = Alignment.Center,
                        transitionSpec = {
                            val targetIndex = targetState.index // targetState == Tab
                            val initialIndex = initialState.index // initialState == Tab

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
                    ) { tab ->
                        MoviePoster(posterDrawable = tab.poster)
                    }
            }
        }
    }
}
