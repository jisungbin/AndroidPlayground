@file:Suppress("RedundantUnitReturnType", "unused")

package land.sungbin.androidplayground

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import land.sungbin.androidplayground.test.setContent

fun main(): Unit {
    val isWorld = true
    setContent {
        Column {
            Row {
                Text("Hi world!")
                if (!isWorld) {
                    Text("Are you world?")
                }
            }
            if (isWorld) {
                Text("Bye world!")
            }
        }
    }
}
