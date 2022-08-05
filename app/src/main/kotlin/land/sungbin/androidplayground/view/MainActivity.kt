@file:Suppress(
    "UNUSED_PARAMETER",
    "FunctionName",
    "UNUSED_VARIABLE"
)

package land.sungbin.androidplayground.view

import androidx.activity.ComponentActivity
import dev.shreyaspatil.mutekt.core.annotations.GenerateMutableModel

class MainActivity : ComponentActivity()

@GenerateMutableModel
interface NotesState {
    val isLoading: Boolean
    val notes: List<String>
    val error: String?
}