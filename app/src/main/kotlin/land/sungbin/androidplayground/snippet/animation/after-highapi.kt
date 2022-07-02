@file:OptIn(ExperimentalAnimationApi::class)
@file:Suppress("ComplexRedundantLet")

package land.sungbin.androidplayground.snippet.animation

import android.content.res.Configuration
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.SizeTransform
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.with
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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsTopHeight
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.ProvideTextStyle
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
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
import land.sungbin.androidplayground.extension.noRippleClickable
import land.sungbin.androidplayground.theme.BackgroundWhite
import land.sungbin.androidplayground.theme.NanumGothicTextStyle

@Preview(
    showBackground = true,
    backgroundColor = 0xFFFFFFFF,
    uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_NORMAL
)
@Composable
fun WithHighApiAnimationDemo() {
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
            verticalArrangement = Arrangement.SpaceBetween
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
                                    color = tabBackgroundColorWithAnimation(
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
                                        color = tabTextColorWithAnimation(
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

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(600.dp),
                shape = RoundedCornerShape(
                    topStart = 30.dp,
                    topEnd = 30.dp
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
                            ) using SizeTransform( // 텍스트 사이즈 바뀌는거 애니메이션 입힘
                                clip = true, // card edge 까지 텍스트 침범? 없어도 잘 되는데 일단 clap false 처리
                                sizeAnimationSpec = { _, _ ->
                                    defaultTween()
                                }
                            )
                        }
                    ) { targetTabFullname ->
                        Text(
                            text = targetTabFullname,
                            style = LocalTextStyle.current.copy(
                                fontSize = 15.sp,
                            )
                        )
                    }

                    AnimatedContent(
                        modifier = Modifier.wrapContentSize(),
                        targetState = selectedTabPosterDrawable,
                        contentAlignment = Alignment.Center,
                        transitionSpec = {
                            (
                                slideIntoContainer(
                                    towards = AnimatedContentScope.SlideDirection.Start,
                                    animationSpec = tween(durationMillis = AnimationDuration),
                                ) with fadeOut(
                                    animationSpec = defaultTween()
                                ) using SizeTransform(
                                    clip = false, // card edge 까지 이미지 침범
                                    sizeAnimationSpec = { _, _ ->
                                        defaultTween()
                                    }
                                )
                                ).apply { // 컨텐츠 겹치는게 해줌
                                // fadeOut 되는거 zIndex 처리 해서 배경으로 보이게 해줌
                                targetContentZIndex = searchTabIndexByDrawable(
                                    drawable = targetState
                                ).toFloat()
                            }
                        }
                    ) { targetTabPosterDrawable ->
                        Image(
                            painter = painterResource(targetTabPosterDrawable),
                            contentScale = ContentScale.Fit,
                            contentDescription = selectedTabTitle
                        )
                    }
                }
            }
        }
    }
}
