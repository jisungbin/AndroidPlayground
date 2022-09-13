@file:Suppress("MayBeConstant")
@file:NoLiveLiterals
@file:OptIn(ExperimentalMaterial3Api::class)

package land.sungbin.androidplayground.view

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.NoLiveLiterals
import androidx.compose.ui.Modifier

class PlaygroundActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Scaffold(
                modifier = Modifier.fillMaxSize(),

            ) {

            }
        }
    }
}