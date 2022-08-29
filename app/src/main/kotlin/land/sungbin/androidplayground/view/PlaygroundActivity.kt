@file:Suppress("MayBeConstant")
@file:NoLiveLiterals

package land.sungbin.androidplayground.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.NoLiveLiterals
import androidx.compose.runtime.mutableStateOf

class Counter {
    val list = emptyList<Any>()
    val number = mutableStateOf(1)

    fun increaseNumber() {
        number.value++
    }
}

class MainActivity : ComponentActivity() {
    private val numberHolder = Counter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val onClickLambda = { numberHolder.increaseNumber() }
            Button(
                onClick = onClickLambda.also {
                    println(it.hashCode())
                }
            ) {
                Text(
                    text = numberHolder.number.value.toString(),
                ).also { println("Text recomposition") }
            }.also { println("Button recomposition") }
        }
    }
}