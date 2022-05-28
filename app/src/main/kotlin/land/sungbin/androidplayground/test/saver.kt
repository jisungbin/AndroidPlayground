package land.sungbin.androidplayground.test

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.mapSaver
import androidx.compose.runtime.saveable.rememberSaveable

private data class City(val name: String = "", val country: String = "")

private val CitySaver = run {
    val nameKey = "Name"
    val countryKey = "Country"
    mapSaver( // listSaver
        save = {
            mapOf(nameKey to it.name, countryKey to it.country)
        },
        restore = {
            City(it[nameKey] as String, it[countryKey] as String)
        }
    )
}

@Composable
fun SaverTest() {
    var selectedCity = rememberSaveable(stateSaver = CitySaver) {
        mutableStateOf(City("Madrid", "Spain"))
    }
}