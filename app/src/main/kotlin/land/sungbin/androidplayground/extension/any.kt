@file:NoLiveLiterals

package land.sungbin.androidplayground.extension

import androidx.compose.runtime.NoLiveLiterals

operator fun Any.invoke(prefix: String = "TestLog") {
    println("$prefix: $this")
}
