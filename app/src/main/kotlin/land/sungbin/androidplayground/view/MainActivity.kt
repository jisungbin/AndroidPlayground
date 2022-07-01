@file:Suppress(
    "SetTextI18n",
    "unused",
    "OPT_IN_IS_NOT_ENABLED",
    "SameParameterValue",
    "UNCHECKED_CAST",
    "LocalVariableName",
    "RemoveExplicitTypeArguments",
    "UnnecessaryOptInAnnotation",
    "ASSIGNED_BUT_NEVER_ACCESSED_VARIABLE",
    "UNUSED_VARIABLE",
    "UnusedImport",
    "CanBeVal",
    "UnrememberedMutableState",
    "ComposableNaming",
    "SpellCheckingInspection"
)
@file:OptIn(
    InternalComposeApi::class,
    ExperimentalLayoutApi::class,
    ExperimentalMaterialApi::class,
    ExperimentalComposeUiApi::class,
    ExperimentalFoundationApi::class,
    ExperimentalAnimationApi::class,
)

package land.sungbin.androidplayground.view

import android.os.Bundle
import android.widget.LinearLayout
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.InternalComposeApi
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import androidx.databinding.DataBindingUtil
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint
import land.sungbin.androidplayground.R
import land.sungbin.androidplayground.databinding.ActivityMainBinding
import land.sungbin.androidplayground.extension.invoke
import land.sungbin.androidplayground.theme.PlaygroundTheme
import land.sungbin.androidplayground.viewmodel.MainViewModel

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var binding: ActivityMainBinding
    private val vm: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.activity_main,
            LinearLayout(this),
            false
        )

        setContent {
            val systemUiController = rememberSystemUiController()

            var visibilityState by remember { mutableStateOf(true) }
            var selectedColorState by remember { mutableStateOf(Color.Red) }

            LaunchedEffect(Unit) {
                WindowCompat.setDecorFitsSystemWindows(window, false)
                systemUiController.setStatusBarColor(
                    color = Color.Transparent,
                    darkIcons = true
                )
                systemUiController.setNavigationBarColor(
                    color = Color.White,
                    darkIcons = true
                )
            }

            PlaygroundTheme {
                Content()
            }
        }
    }
}

@Preview
@Composable
private fun Content() {
    val textField = remember { mutableStateOf(TextFieldValue()) }
    val confirmTextField = remember { mutableStateOf(TextFieldValue()) }
    var pass by remember { mutableStateOf(true) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 100.dp),
        verticalArrangement = Arrangement.spacedBy(space = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        listOf(
            Triple(R.string.input_text, textField, R.string.input_text_tag),
            Triple(R.string.confirm_text, confirmTextField, R.string.confirm_text_tag)
        ).forEach { (label, textFieldValue, textFieldTestTag) ->
            Column {
                Text(text = stringResource(label))
                OutlinedTextField(
                    modifier = Modifier
                        .padding(top = 8.dp)
                        .testTag(stringResource(textFieldTestTag)),
                    value = textFieldValue.value,
                    onValueChange = { newTextFieldValue ->
                        textFieldValue.value = newTextFieldValue
                    },
                    singleLine = true,
                    maxLines = 1
                )
            }
        }
        Button(
            onClick = {
                pass = textField.value.text == confirmTextField.value.text
            }
        ) {
            Text(text = stringResource(R.string.check_text))
        }
        Text(
            modifier = Modifier.testTag(stringResource(R.string.check_result)),
            text = when (pass) {
                true -> stringResource(R.string.pass)
                else -> stringResource(R.string.fail)
            }
        )
    }
}
