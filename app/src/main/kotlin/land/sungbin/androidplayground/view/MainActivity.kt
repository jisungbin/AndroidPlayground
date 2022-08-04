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
interface PaginationListState<Key> {
    val isPaging: Boolean
    val isRetrying: Boolean

    val prevPageKey: Key?
    val currentPageKey: Key
    val nextPageKey: Key?

    suspend fun refresh() // reset all paged data, and restart from the init
    suspend fun retry() // re-request last paged
    fun cancel() // cancel all pagination requests and shutdown paging system
    fun exception(exception: Throwable) // To notify the exception raised by the user to PageItemState
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
}

@Immutable
interface PaginationListScope<T> {
    // can be header, footer, separator, item, etc...
    // item is null when it's placeholder
    fun items(content: @Composable (item: T?, state: PageItemState) -> Unit)
}

@Immutable
interface PagingSource<T, Key> {
    suspend fun loadPage(pageKey: Key): Result<List<T>>

    fun calcNextPageKey(currentPageKey: Key): Key? // return: null if next page key is none
}

/**
 * ### We want to implement this:
 *
 * - separater
 * - header/footer
 * - retry and exception handling method
 * - auto remove duplicate request
 * - online + offline page load
 */
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
    userScrollEnabled: Boolean = true,
    content: PaginationListScope<T>.() -> Unit
) {

}