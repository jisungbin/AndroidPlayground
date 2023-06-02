package aaaa.quackicon

import aaaa.QuackIcon
import aaaa.quackicon.aaaa.AllAssets
import aaaa.quackicon.aaaa.Quackicon
import androidx.compose.ui.graphics.vector.ImageVector
import kotlin.collections.List as ____KtList

public object AaaaGroup

public val QuackIcon.Aaaa: AaaaGroup
  get() = AaaaGroup

private var __AllAssets: ____KtList<ImageVector>? = null

public val AaaaGroup.AllAssets: ____KtList<ImageVector>
  get() {
    if (__AllAssets != null) {
      return __AllAssets!!
    }
    __AllAssets = Quackicon.AllAssets + listOf()
    return __AllAssets!!
  }
