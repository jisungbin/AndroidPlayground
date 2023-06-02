package aaaa.quackicon.aaaa

import kotlin.collections.List as ____KtList
import aaaa.quackicon.AaaaGroup
import androidx.compose.ui.graphics.vector.ImageVector

public object QuackiconGroup

public val AaaaGroup.Quackicon: QuackiconGroup
  get() = QuackiconGroup

private var __AllAssets: ____KtList<ImageVector>? = null

public val QuackiconGroup.AllAssets: ____KtList<ImageVector>
  get() {
    if (__AllAssets != null) {
      return __AllAssets!!
    }
    __AllAssets = listOf()
    return __AllAssets!!
  }
