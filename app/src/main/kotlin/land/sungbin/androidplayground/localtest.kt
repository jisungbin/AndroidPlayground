package land.sungbin.androidplayground

import android.os.Binder
import android.os.Parcelable
import android.util.Size
import android.util.SizeF
import android.util.SparseArray
import java.io.Serializable

private val AcceptableClasses = listOf(
    Serializable::class.java,
    Parcelable::class.java,
    String::class.java,
    SparseArray::class.java,
    Binder::class.java,
    Size::class.java,
    SizeF::class.java
)

fun main() {
    val intHolder = listOf(IntHolder(1))
    AcceptableClasses.forEach { instance ->
        println("${instance.simpleName}: ${instance.isInstance(null)}")
    }
    // println(ArrayList(listOf(1)))
}