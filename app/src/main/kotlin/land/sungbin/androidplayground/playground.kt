package land.sungbin.androidplayground

import androidx.activity.ComponentActivity
import androidx.paging.PagingConfig

class EmptyActivity : ComponentActivity()

fun main() {
    PagingConfig(
        pageSize = 0,
        prefetchDistance = 0,
        enablePlaceholders = false,
        initialLoadSize = 1,
        maxSize = 2,
        jumpThreshold = 0
    )
}