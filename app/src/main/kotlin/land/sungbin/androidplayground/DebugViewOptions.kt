package land.sungbin.androidplayground

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.SemanticsPropertyKey
import androidx.compose.ui.semantics.semantics

@Suppress("ObjectPropertyName")
object DebugViewOptions {
  internal val _enabled = mutableStateOf(true)
  var enabled by _enabled

  var resolver = DebugData.Resolver { node ->
    DebugData(
      name = node.id.toString(),
      contents = listOf(
        "id: ${node.id}",
        "size: ${node.size}",
        "position: ${node.positionInRoot}",
      ),
    )
  }

  val Semantics = SemanticsPropertyKey<Unit>("DebugView")
}

@Suppress("unused")
fun Modifier.debugView() = semantics { this[DebugViewOptions.Semantics] = Unit }
