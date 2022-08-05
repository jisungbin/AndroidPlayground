@file:Suppress(
    "UNUSED_PARAMETER",
    "FunctionName",
    "UNUSED_VARIABLE", "KDocUnresolvedReference"
)

package land.sungbin.androidplayground.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

open class PeopleWrapper(open val name: String, open val age: Int) {
    override fun toString() = "name: $name, age: $age"
}

class MutablePeopleImplWrapper(name: String, age: Int) : PeopleWrapper(name, age) {
    private val _name = MutableStateFlow(name)
    override var name
        get() = _name.value
        set(value) {
            _name.value = value
        }

    private val _age = MutableStateFlow(age)
    override var age
        get() = _age.value
        set(value) {
            _age.value = value
        }

    private val immutableImpl = object : StateFlow<PeopleWrapper> {
        override val replayCache: List<PeopleWrapper> get() = listOf(value)

        override val value
            get() = PeopleWrapper(
                name = _name.value,
                age = _age.value
            )

        override suspend fun collect(collector: FlowCollector<PeopleWrapper>): Nothing =
            coroutineScope {
                combine(_name, _age) { params ->
                    PeopleWrapper(
                        name = params[0] as String,
                        age = params[1] as Int
                    )
                }.stateIn(this).collect(collector)
            }
    }

    fun asStateFlow() = immutableImpl
}

fun People(name: String, age: Int) = MutablePeopleImplWrapper(name, age)

class MainActivity : ComponentActivity() {
    private val people = People("Ji", 0)

    /**
     * [Dispatchers.Main]
     * I/System.out: Sungbin, age: 21
     *
     * [Dispatchers.Main.immediate]
     * I/System.out: name: Ji, age: 0
     * I/System.out: name: Sungbin, age: 0
     * I/System.out: name: Sungbin, age: 21
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        CoroutineScope(Dispatchers.Main.immediate).launch {
            people.asStateFlow().collect {
                println(it)
            }
        }
    }

    override fun onResume() {
        super.onResume()
        people.apply {
            name = "Sungbin"
            age = 21
        }
    }
}
