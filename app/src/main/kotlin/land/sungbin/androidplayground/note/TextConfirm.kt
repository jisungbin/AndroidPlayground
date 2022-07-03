@file:NoLiveLiterals

package land.sungbin.androidplayground.note

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.NoLiveLiterals
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import land.sungbin.androidplayground.R
import land.sungbin.androidplayground.annotation.BackgroundPreview

@BackgroundPreview
@Composable
fun TextConfirm() {
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
