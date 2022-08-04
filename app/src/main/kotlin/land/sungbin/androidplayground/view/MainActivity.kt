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
import androidx.paging.PagingConfig
import javax.annotation.concurrent.Immutable

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

        }
        PagingConfig
    }
}

@Immutable
interface PaginationListState {
    val isPageBegin: Boolean
    val isPageEnd: Boolean

    val isPaging: Boolean // `isLoading` is better naming?
    val isRetrying: Boolean
    val exception: Exception?
    val isException get() = exception != null

    val prevPageNumber: Int
    val nowPageNumber: Int
    val nextPageNumber: Int
}

@Immutable
interface PaginationListController {
    val pageSize: Int
    val initPageListSize: Int
    val prefetchPageListDistance: Int
    val enablePlaceholders: Boolean
    val loadedPageListMaxSize: Int

    fun retry()
    fun cancel()
    fun exception(exception: Throwable) // To notify the exception raised by the user to PaginationListState
}

@Immutable
interface PaginationListScope<T> {
    // for Header, Footer, Separater
    fun item(
        visible: (state: PaginationListState) -> Boolean,
        content: @Composable (
            prevItem: T?, // null if no prev item
            nextItem: T?, // null if no next item
            fromOffline: Boolean
        ) -> Unit
    )

    fun items(content: @Composable (item: T, fromOffline: Boolean) -> Unit)
}

/**
 * We first fetch the data from offline,
 * and if it fails or there is no data, we re-fetch it from online.
 */
@Immutable
interface PagingSource<T> {
    suspend fun saveToOffline(pageNumber: Int, items: List<T>): Boolean // return: result

    suspend fun loadFromOffline(pageNumber: Int): List<T>? // return: null if load failed

    suspend fun loadFromOnline(pageNumber: Int): List<T>? // return: null if load failed

    fun mustLoadFromOnline(item: T): Boolean
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
fun <T> PaginationColumn(
    modifier: Modifier = Modifier,
    pagingController: PaginationListController,
    pagingSource: PagingSource<T>,
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