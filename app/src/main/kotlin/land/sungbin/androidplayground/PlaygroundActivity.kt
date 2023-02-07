@file:NoLiveLiterals

package land.sungbin.androidplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.NoLiveLiterals
import androidx.compose.runtime.collection.MutableVector
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController

class PlaygroundActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { Text("HI") }
    }
}

@Composable
@ExperimentalComposeUiApi
@ExperimentalFoundationApi
fun <Item, Section : List<Item>, Key> ExList(
    itemsInSections: List<Section>,
    expandedSectionsState: Set<Key>,
    sectionKey: (Section) -> Key,
    modifier: Modifier = Modifier,
    topHeaderLayout: @Composable (() -> Unit)? = null,
    hLayout: @Composable ((Int, Boolean, Int) -> Unit)? = null,
    layout: @Composable ((Any?) -> Unit)? = null,
    footerLayout1: @Composable (() -> Unit)? = null,
    footerLayout: @Composable (() -> Unit)? = null,
    isSecSticky: Boolean = true,
    searchQuery: String,
) {
    val lazyListState = rememberLazyListState()
    val keyboardController = LocalSoftwareKeyboardController.current

    LaunchedEffect(lazyListState.isScrollInProgress) {
        if (lazyListState.isScrollInProgress) {
            keyboardController?.hide()
        }
    }

    val openSectionsWithChildrenAmount = remember { MutableVector<Int>() }
    var sectionIsOpen by remember { mutableStateOf(false) }
    var headerIndex = remember {
        derivedStateOf {
            lazyListState.layoutInfo.visibleItemsInfo.firstOrNull()?.index ?: -1
        }
    }.value

    LazyColumn(
        state = lazyListState,
        modifier = modifier
    ) {
        topHeaderLayout?.let { topLayoutHeader ->
            item {
                topLayoutHeader.invoke()
            }
        }

        itemsInSections.forEachIndexed { sectionIndex, section ->
            sectionIsOpen = searchQuery.isNotBlank() || expandedSectionsState.contains(sectionKey(section))

            if (isSecSticky) {
                openSectionsWithChildrenAmount.ensureCapacity(itemsInSections.size)

                if (sectionIsOpen) {
                    openSectionsWithChildrenAmount[sectionIndex] = section.size
                } else {
                    openSectionsWithChildrenAmount[sectionIndex] = 0
                }

                for (i in 0 until sectionIndex) {
                    if ((headerIndex != -1)) {
                        headerIndex -= openSectionsWithChildrenAmount[i]
                    }
                }

                stickyHeader {
                    hLayout?.invoke(
                        sectionIndex,
                        sectionIsOpen,
                        headerIndex
                    )
                }
            } else {
                hLayout?.let {
                    item {
                        it.invoke(
                            sectionIndex,
                            sectionIsOpen,
                            -1
                        )
                    }
                }
            }

            if (sectionIsOpen) {
                layout?.let {
                    items(section) { item ->
                        it.invoke(item)
                    }
                }

                footerLayout1?.let {
                    item {
                        it.invoke()
                    }
                }
            }
        }

        footerLayout?.let {
            item {
                it.invoke()
            }
        }
    }
}
