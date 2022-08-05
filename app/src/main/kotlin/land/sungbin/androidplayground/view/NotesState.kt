@file:Suppress("UNCHECKED_CAST")

package land.sungbin.androidplayground.view

import dev.shreyaspatil.mutekt.core.StateFlowable
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn

interface NotesState {
    val isLoading: Boolean
    val notes: List<String>
    val error: String?
}

interface StateFlowable<T> {
    fun asStateFlow(): StateFlow<T>
}

interface MutableNotesState : NotesState, StateFlowable<NotesState> {
    override var isLoading: Boolean
    override var notes: List<String>
    override var error: String?
}

private data class ImmutableNotesState(
    override val isLoading: Boolean,
    override val notes: List<String>,
    override val error: String?,
) : NotesState

private class MutableNotesStateImpl(
    isLoading: Boolean,
    notes: List<String>,
    error: String?,
) : MutableNotesState {
    private val _isLoading: MutableStateFlow<Boolean> = MutableStateFlow(isLoading)
    override var isLoading: Boolean
        get() = _isLoading.value
        set(value) {
            _isLoading.value = value
        }

    private val _notes: MutableStateFlow<List<String>> = MutableStateFlow(notes)
    override var notes: List<String>
        get() = _notes.value
        set(value) {
            _notes.value = value
        }

    private val _error: MutableStateFlow<String?> = MutableStateFlow(error)
    override var error: String?
        get() = _error.value
        set(`value`) {
            _error.value = value
        }

    private val _immutableStateFlowImpl: StateFlow<NotesState> = object : StateFlow<NotesState> {
        override val replayCache: List<NotesState> get() = listOf(value)

        override val value: NotesState
            get() = ImmutableNotesState(
                isLoading = _isLoading.value,
                notes = _notes.value,
                error = _error.value,
            )

        override suspend fun collect(collector: FlowCollector<NotesState>): Nothing =
            coroutineScope {
                combine(_isLoading, _notes, _error) { params ->
                    ImmutableNotesState(
                        isLoading = params[0] as Boolean,
                        notes = params[1] as List<String>,
                        error = params[2] as String?,
                    )
                }.stateIn(this).collect(collector)
            }
    }

    override fun asStateFlow(): StateFlow<NotesState> = _immutableStateFlowImpl
}

fun MutableNotesState(
    isLoading: Boolean = false,
    notes: List<String> = emptyList(),
    error: String? = null,
): MutableNotesState = MutableNotesStateImpl(isLoading, notes, error)