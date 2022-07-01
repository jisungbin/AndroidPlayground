@file:Suppress("ModifierParameter")
@file:NoLiveLiterals

package land.sungbin.androidplayground.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.runtime.Composable
import androidx.compose.runtime.NoLiveLiterals
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

private val DefaultPadding = 30.dp

@Composable
fun SortedColumn(
    backgroundColor: Color = Color.White,
    modifier: Modifier = Modifier
        .fillMaxSize()
        .background(color = backgroundColor),
    space: Dp = DefaultPadding,
    content: @Composable ColumnScope.() -> Unit
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(
            space = space,
            alignment = Alignment.CenterVertically
        ),
        horizontalAlignment = Alignment.CenterHorizontally,
        content = content
    )
}

@Composable
fun SortedLazyColumn(
    backgroundColor: Color = Color.White,
    modifier: Modifier = Modifier
        .fillMaxSize()
        .background(color = backgroundColor),
    space: Dp = DefaultPadding,
    paddingValues: PaddingValues = PaddingValues(vertical = space),
    content: LazyListScope.() -> Unit
) {
    LazyColumn(
        modifier = modifier,
        contentPadding = paddingValues,
        verticalArrangement = Arrangement.spacedBy(
            space = space,
            alignment = Alignment.CenterVertically
        ),
        horizontalAlignment = Alignment.CenterHorizontally,
        content = content
    )
}
