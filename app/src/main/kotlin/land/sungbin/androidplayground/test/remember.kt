@file:Suppress("UNUSED_VARIABLE", "SpellCheckingInspection", "unused")

package land.sungbin.androidplayground.test

import androidx.compose.runtime.Composable
import androidx.compose.runtime.currentCompositeKeyHash
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.Saver
import androidx.compose.runtime.saveable.autoSaver
import androidx.compose.runtime.saveable.mapSaver
import androidx.compose.runtime.saveable.rememberSaveable

private data class RealPeople(val name: String = "Ji Sungbin", val gender: String = "Male")

private val RealPeopleSaver = run {
    val nameKey = "Name"
    val countryKey = "Country"
    mapSaver( // listSaver
        save = {
            mapOf(nameKey to it.name, countryKey to it.gender)
        },
        restore = {
            RealPeople(it[nameKey] as String, it[countryKey] as String)
        }
    )
}

@Composable
fun RememberTest() {
    val value = remember { 0 }
    val valueSaveable = rememberSaveable { 0 }
}

@Composable
fun SaverTest() {
    var selectedRealPeople = rememberSaveable(stateSaver = RealPeopleSaver) {
        mutableStateOf(RealPeople("Madrid", "Spain"))
    }
}

@Composable
fun <T> fakeRemember(
    vararg keys: Any?,
    calculation: () -> T
): T = calculation()

@Composable
fun <T : Any> fakeRememberSaveable(
    vararg inputs: Any?,
    saver: Saver<T, out Any> = autoSaver(),
    key: String? = null,
    init: () -> T
): T {

    val finalKey: String = if (!key.isNullOrEmpty()) {
        key
    } else {
        // 외부에 저장된 상태를 컴포지션에 매핑하는 데 사용되는 해시 값
        currentCompositeKeyHash.toString()
    }

    return init()
}

data class People(val name: String = "Ji Sungbin", val gender: String = "Male")

val PeopleSaver = run {
    val nameKey = "Name"
    val countryKey = "Country"
    mapSaver( // listSaver
        save = {
            mapOf(nameKey to it.name, countryKey to it.gender)
        },
        restore = {
            People(it[nameKey] as String, it[countryKey] as String)
        }
    )
}