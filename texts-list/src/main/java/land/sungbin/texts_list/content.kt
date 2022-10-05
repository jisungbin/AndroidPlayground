package land.sungbin.texts_list

import androidx.compose.runtime.Composable
import androidx.compose.runtime.snapshots.SnapshotStateList

@Composable
fun Texts(
    texts: SnapshotStateList<String>,
    content: @Composable () -> Unit,
) {
    println(texts.joinToString("\n"))
    content()
}
