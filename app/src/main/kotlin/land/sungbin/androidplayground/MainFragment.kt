@file:Suppress("UselessCallOnNotNull")

package land.sungbin.androidplayground

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope

class MainFragment : Fragment() {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycleScope
        viewLifecycleOwner.lifecycle
        "".orEmpty()
    }
}