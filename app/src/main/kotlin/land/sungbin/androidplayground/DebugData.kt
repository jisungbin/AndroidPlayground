package land.sungbin.androidplayground

import androidx.compose.ui.semantics.SemanticsNode

data class DebugData(
  val name: String = "",
  val contents: List<String>,
  internal val raw: SemanticsNode,
) {
  init {
    require(contents.isNotEmpty()) { "debug contents must not be empty" }
  }

  fun interface Resolver {
    fun resolve(node: SemanticsNode): DebugData
  }
}

@Suppress("NOTHING_TO_INLINE")
inline operator fun DebugData.Resolver.invoke(node: SemanticsNode) = resolve(node)
