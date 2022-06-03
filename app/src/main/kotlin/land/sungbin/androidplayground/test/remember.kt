@file:Suppress("UNUSED_VARIABLE", "SpellCheckingInspection", "unused", "UNCHECKED_CAST")

package land.sungbin.androidplayground.test

import android.os.Binder
import android.os.Parcelable
import android.util.Size
import android.util.SizeF
import android.util.SparseArray
import androidx.compose.runtime.Composable
import androidx.compose.runtime.currentCompositeKeyHash
import androidx.compose.runtime.neverEqualPolicy
import androidx.compose.runtime.referentialEqualityPolicy
import androidx.compose.runtime.saveable.Saver
import androidx.compose.runtime.saveable.autoSaver
import androidx.compose.runtime.snapshots.SnapshotMutableState
import androidx.compose.runtime.structuralEqualityPolicy
import java.io.Serializable

@Composable
fun <T> fakeRemember(
    vararg keys: Any?,
    calculation: () -> T,
): T = calculation()

@Composable
fun <T : Any> fakeRememberSaveable(
    vararg inputs: Any?,
    saver: Saver<T, out Any> = autoSaver(),
    key: String? = null,
    init: () -> T,
): T {
    val finalKey: String = if (!key.isNullOrEmpty()) {
        key
    } else {
        // 외부에 저장된 상태를 컴포지션에 매핑하는 데 사용되는 해시 값
        currentCompositeKeyHash.toString()
    }

    return init()
}

interface Saver<Original, Saveable> {
    // 값을 저장 가능한 값으로 변환
    fun save(value: Original): Saveable?

    // 저장한 값을 원래의 값으로 변환
    fun restore(value: Saveable): Original?
}

private val AutoSaver = Saver<Any, Any>(
    save = { it },
    restore = { it }
)

fun <T> autoSaver() = AutoSaver as Saver<T, Any>

val AcceptableClasses = listOf(
    Serializable::class.java,
    Parcelable::class.java,
    String::class.java,
    SparseArray::class.java,
    Binder::class.java,
    Size::class.java,
    SizeF::class.java
)

fun canBeSavedToBundle(value: Any): Boolean {
    if (value is SnapshotMutableState<*>) {
        return if (value.policy === neverEqualPolicy<Any?>() ||
            value.policy === structuralEqualityPolicy<Any?>() ||
            value.policy === referentialEqualityPolicy<Any?>()
        ) {
            val stateValue = value.value
            if (stateValue == null) true
            else canBeSavedToBundle(stateValue)
        } else {
            false
        }
    }
    for (cl in AcceptableClasses) {
        if (cl.isInstance(value)) {
            return true
        }
    }
    return false
}
