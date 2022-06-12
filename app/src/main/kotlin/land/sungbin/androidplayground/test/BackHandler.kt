@file:OptIn(ExperimentalMaterialApi::class)
@file:Suppress("MissingSuperCall")
@file:NoLiveLiterals

package land.sungbin.androidplayground.test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.NoLiveLiterals
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.lifecycleScope

@Composable
fun BackHandlerTest() {
    var isBackPressed by remember { mutableStateOf(false) }

    BackHandler(!isBackPressed) {
        isBackPressed = true
    }

    Text("뒤로가기 눌림: $isBackPressed")
}

@Composable
private fun DummyBackHandler() {

    var isBackPressed by remember { mutableStateOf(false) }

    BackHandler(enabled = !isBackPressed) {
        isBackPressed = true
    }

    Text("뒤로가기 눌림: $isBackPressed")
}

class MainActivity : ComponentActivity() {
    private lateinit var onBackPressedAction: () -> Unit

    override fun onCreate(savedInstanceState: Bundle?) {
        setContent {
            val bottomSheetState = rememberModalBottomSheetState(ModalBottomSheetValue.Expanded)

            onBackPressedAction = {
                lifecycleScope.launchWhenCreated {
                    bottomSheetState.hide()
                }
            }

            ModalBottomSheetLayout(
                sheetState = bottomSheetState,
                sheetContent = { Text("Bye, world!") },
                content = {}
            )
        }
    }

    override fun onBackPressed() {
        onBackPressedAction()
    }
}
