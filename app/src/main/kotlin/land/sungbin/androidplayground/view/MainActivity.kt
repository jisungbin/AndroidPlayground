@file:Suppress("PrivatePropertyName")

package land.sungbin.androidplayground.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList
import land.sungbin.androidplayground.R

class MainActivity : ComponentActivity() {

    private val SungbinLand by lazy { getString(R.string.sungbin_land) }
    private val SungbinLands by lazy { listOf(SungbinLand) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            DisplayText(SungbinLand)
//            DisplayTexts(SungbinLands.toImmutableList())
        }
    }

    @Composable
    fun DisplayText(text: String = "SungbinLand") {
        Text(text = text)
    }

    @Composable
    fun DisplayTexts(text: ImmutableList<String> = SungbinLands.toImmutableList()) {
        Text(text = text.joinToString())
    }
}