package land.sungbin.androidplayground.test

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.mapSaver
import androidx.compose.runtime.saveable.rememberSaveable

data class People(val name: String, val age: Int)

val PeopleSaver = mapSaver<People>