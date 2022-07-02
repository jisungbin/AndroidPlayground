@file:OptIn(ExperimentalAnimationApi::class, ExperimentalTransitionApi::class)

package land.sungbin.androidplayground.snippet.animation

import android.content.res.Configuration
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
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ProvideTextStyle
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import land.sungbin.androidplayground.extension.StatusBarHeightDp
import land.sungbin.androidplayground.extension.noRippleClickable
import land.sungbin.androidplayground.extension.toPercent
import land.sungbin.androidplayground.snippet.animation.component.TabFullname
import land.sungbin.androidplayground.snippet.animation.component.TabPoster
import land.sungbin.androidplayground.snippet.animation.component.TabTitle
import land.sungbin.androidplayground.theme.BackgroundWhite
import land.sungbin.androidplayground.theme.NanumGothicTextStyle

@Composable
private fun TabSelector(
    selectedTabTransition: Transition<TabType>,
    updateSelectedTabType: (type: TabType) -> Unit
) {
    BoxWithConstraints(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .clip(
                RoundedCornerShape(
                    bottomStartPercent = 30,
                    bottomEndPercent = 30
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
                TabType.Thor -> RoundedCornerShape(bottomStartPercent = 30)
                TabType.Spider -> RoundedCornerShape(percent = 0)
                TabType.Doctor -> RoundedCornerShape(bottomEndPercent = 30)
            }
        }

        SideEffect {
            println(backgroundShapeTransition)
        }

        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            elevation = 10.dp
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
            ) {
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

                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .height(StatusBarHeightDp + 50.dp)
                            .background(color = TabDefaults.Color.defaultBackground)
                            .noRippleClickable {
                                updateSelectedTabType(type)
                            },
                        contentAlignment = Alignment.Center
                    ) {
                        TabTitle(
                            modifier = Modifier.padding(top = StatusBarHeightDp),
                            title = type.string,
                            textColor = textColor
                        )
                    }
                }
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

@Preview(
    showBackground = true,
    backgroundColor = 0xFFFFFFFF,
    uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_NORMAL
)
@Composable
fun WithLowApiAnimationAndTabSelectorDemo() {
    var selectedTabTypeState by remember { mutableStateOf(TabType.Thor) }
    val selectedTabTransition = updateTransition(
        targetState = selectedTabTypeState,
        label = "selected tab"
    )
    val selectedTabFullnameTransition = selectedTabTransition.createChildTransition(
        label = "selected tab fullname",
        transformToChildState = { selectedTabType ->
            val (_, _, selectedTabFullname) = TabDefaults.Items[selectedTabType.ordinal]
            selectedTabFullname
        }
    )
    val selectedTabPosterTransition = selectedTabTransition.createChildTransition(
        label = "selected tab poster",
        transformToChildState = { selectedTabType -> selectedTabType }
    )

    ProvideTextStyle(NanumGothicTextStyle) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.BackgroundWhite),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            TabSelector(
                selectedTabTransition = selectedTabTransition,
                updateSelectedTabType = { newSelectedTabType ->
                    selectedTabTypeState = newSelectedTabType
                }
            )

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
                    selectedTabFullnameTransition.AnimatedContent(
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
                    ) { selectedTabFullname ->
                        TabFullname(selectedTabFullname = selectedTabFullname)
                    }

                    selectedTabPosterTransition.AnimatedContent(
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
                        val (_, selectedTabPoster, _) = TabDefaults.Items[selectedTabType.ordinal]

                        TabPoster(
                            selectedTabPosterDrawable = selectedTabPoster,
                            posterDescription = selectedTabType.string
                        )
                    }
                }
            }
        }
    }
}
