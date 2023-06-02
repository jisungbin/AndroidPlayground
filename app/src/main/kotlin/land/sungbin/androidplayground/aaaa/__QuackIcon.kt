package aaaa

import aaaa.quackicon.Aaaa
import aaaa.quackicon.AllAssets
import aaaa.quackicon.Explore24Fill
import aaaa.quackicon.Home224Fill
import aaaa.quackicon.Home24Fill
import androidx.compose.ui.graphics.vector.ImageVector
import kotlin.collections.List as ____KtList

public object QuackIcon

private var __AllAssets: ____KtList<ImageVector>? = null

public val QuackIcon.AllAssets: ____KtList<ImageVector>
  get() {
    if (__AllAssets != null) {
      return __AllAssets!!
    }
    __AllAssets = Aaaa.AllAssets + listOf(Home224Fill, Home24Fill, Explore24Fill)
    return __AllAssets!!
  }
