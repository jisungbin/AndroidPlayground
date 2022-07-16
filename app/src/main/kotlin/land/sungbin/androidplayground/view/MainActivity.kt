@file:Suppress("PrivatePropertyName")

package land.sungbin.androidplayground.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.NoLiveLiterals
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
}

@NoLiveLiterals
@Composable
fun DisplayText(text: String = "SungbinLand") {
    Text(text = text)
}