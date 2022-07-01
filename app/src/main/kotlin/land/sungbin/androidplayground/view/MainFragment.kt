@file:Suppress(
    "UselessCallOnNotNull",
    "RedundantOverride"
)
@file:NoLiveLiterals

package land.sungbin.androidplayground.view

import android.os.Bundle
import android.view.View
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.NoLiveLiterals
import androidx.fragment.app.Fragment

class MainFragment : Fragment() {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // ...
    }

    @NoLiveLiterals
    @Composable
    fun Foo() {
        Text("Bar!")
    }
}
