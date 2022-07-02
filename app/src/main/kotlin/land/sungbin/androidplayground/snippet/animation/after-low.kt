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
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsTopHeight
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ProvideTextStyle
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import land.sungbin.androidplayground.extension.noRippleClickable
import land.sungbin.androidplayground.snippet.animation.component.TabFullname
import land.sungbin.androidplayground.snippet.animation.component.TabPoster
import land.sungbin.androidplayground.snippet.animation.component.TabTitle
import land.sungbin.androidplayground.theme.BackgroundWhite
import land.sungbin.androidplayground.theme.NanumGothicTextStyle

@Preview(
    showBackground = true,
    backgroundColor = 0xFFFFFFFF,
    uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_NORMAL
)
@Composable
fun WithLowApiAnimationDemo() {
    var selectedTabTypeState by remember { mutableStateOf(TabType.Thor) }
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
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .clip(
                        RoundedCornerShape(
                            bottomStart = DefaultCornerSize,
                            bottomEnd = DefaultCornerSize
                        )
                    ),
                elevation = 10.dp
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                ) {
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

                        Column(
                            modifier = Modifier
                                .weight(1f)
                                .wrapContentHeight()
                                .background(color = backgroundColor)
                                .noRippleClickable {
                                    selectedTabTypeState = type
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
                                TabTitle(
                                    title = type.string,
                                    textColor = textColor
                                )
                            }
                        }
                    }
                }
            }

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(600.dp),
                shape = RoundedCornerShape(
                    topStart = DefaultCornerSize,
                    topEnd = DefaultCornerSize
                ),
                elevation = 10.dp,
                backgroundColor = Color.White
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(15.dp)
                ) {
                    selectedTabTransition.AnimatedContent(
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .padding(horizontal = 30.dp),
                        transitionSpec = {
                            fadeIn(
                                animationSpec = defaultTween()
                            ) with fadeOut(
                                animationSpec = defaultTween()
                            ) using SizeTransform( // 텍스트 사이즈 바뀌는거 애니메이션 입힘
                                clip = true, // card edge 까지 텍스트 침범? 없어도 잘 되는데 일단 clap false 처리
                                sizeAnimationSpec = { _, _ ->
                                    defaultTween()
                                }
                            )
                        }
                    ) { selectedTabType ->
                        val (_, _, selectedTabFullname) = TabDefaults.Items[selectedTabType.ordinal]
                        TabFullname(selectedTabFullname = selectedTabFullname)
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
                                // fadeOut 되는거 zIndex 처리 해서 배경으로 보이게 해줌
                                targetContentZIndex = targetIndex.toFloat()
                            }
                        }
                    ) { selectedTabType ->
                        val (_, selectedTabPosterDrawable, _) = TabDefaults.Items[selectedTabType.ordinal]

                        TabPoster(
                            selectedTabPosterDrawable = selectedTabPosterDrawable,
                            posterDescription = selectedTabType.string
                        )
                    }
                }
            }
        }
    }
}
