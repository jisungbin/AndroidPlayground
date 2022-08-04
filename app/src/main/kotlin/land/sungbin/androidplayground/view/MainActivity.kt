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

    val prevPageKey: Key? // null if first page
    val currentPageKey: Key
    val nextPageKey: Key?

    suspend fun refresh() // reset all paged data, and restart from the init
    suspend fun retry()
    fun cancel() // cancel all pagination requests and shutdown paging system
    fun exception(exception: Throwable) // To notify the exception raised by the user to PageItemState
}

@Immutable
interface PaginationListConfig {
    val pageSize: Int
    val initPageListSize: Int
    val prefetchPageListDistance: Int
    val enablePlaceholders: Boolean
    val loadedPageListMaxSize: Int
}

@Immutable
interface PageItemState {
    val isFirstItem: Boolean
    val isLastItem: Boolean? // null if unknown, only true when next page key is null and the last paged item is visible
    val isPlaceholder: Boolean
    val isLoadedFromOffline: Boolean
    val exception: Throwable?

    val isException get() = exception != null
}

@Immutable
interface PaginationListScope<T> {
    // can be footer, header, separator, item, etc...
    fun items(content: @Composable (item: T?, state: PageItemState) -> Unit)
}

/**
 * We first fetch the data from offline,
 * and if it fails or there is no data, we re-fetch it from online.
 */
@Immutable
interface PagingSource<T, Key> {
    suspend fun saveToOffline(pageKey: Key, items: List<T>): Boolean // return: result

    suspend fun loadFromOffline(pageKey: Key): List<T>? // return: null if load failed

    suspend fun loadFromOnline(pageKey: Key): List<T>? // return: null if load failed

    fun mustLoadFromOnline(item: T): Boolean

    // lastItem: last item on the current page
    fun calcNextPageKey(currentPageKey: Key, lastItem: T): Key? // return: null if next page key is none.
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