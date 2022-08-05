@file:Suppress(
    "UNUSED_PARAMETER",
    "FunctionName",
    "UNUSED_VARIABLE"
)

package land.sungbin.androidplayground.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.gestures.FlingBehavior
import androidx.compose.foundation.gestures.ScrollableDefaults
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import javax.annotation.concurrent.Immutable

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
        }
    }
}

@Immutable
interface PaginationListConfig {
    val initPrefetchPageCount: Int
    val prefetchPageListDistance: Int
    val enablePlaceholders: Boolean
    val loadedPageListMaxSize: Int
}

@Immutable
interface PageItemState {
    val isFirstItem: Boolean
    val isLastItem: Boolean // only true when next page key is null and the last paged item is visible
    val isPlaceholder: Boolean
    val exception: Throwable?

    suspend fun retry(): Boolean
}

@Immutable
interface PaginationListScope<T> {
    // can be header, footer, separator, item, etc...
    // item is null when it's placeholder
    fun items(content: @Composable (item: T?, itemState: PageItemState) -> Unit)
}

@Immutable
interface PagingSource<T, Key> {
    suspend fun loadPage(pageKey: Key): Result<List<T>>

    fun calcNextPageKey(currentPageKey: Key): Key? // return: null if next page key is none
}

@Composable
fun <T, Key> PaginationColumn(
    modifier: Modifier = Modifier,
    pagingConfig: PaginationListConfig,
    pagingSource: PagingSource<T, Key>,
    contentPadding: PaddingValues = PaddingValues(0.dp),
    reverseLayout: Boolean = false,
    verticalArrangement: Arrangement.Vertical = when (reverseLayout) {
        true -> Arrangement.Bottom
        else -> Arrangement.Top
    },
    horizontalAlignment: Alignment.Horizontal = Alignment.Start,
    flingBehavior: FlingBehavior = ScrollableDefaults.flingBehavior(),
    content: PaginationListScope<T>.() -> Unit
) {

}