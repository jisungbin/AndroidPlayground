@file:Suppress("SetTextI18n", "unused", "OPT_IN_IS_NOT_ENABLED", "SameParameterValue")

package land.sungbin.androidplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.selection.DisableSelection
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.currentRecomposeScope
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import land.sungbin.androidplayground.databinding.ActivityMainBinding

private class IntHolder {
    var value = 0
        set(value) {
            println("Set: $value")
            field = value
        }
}

class MainActivity : ComponentActivity() {

    private var state by mutableStateOf(1)
    private lateinit var binding: ActivityMainBinding
    private val vm: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /*binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        vm.collect { value, type ->
            println("Collected $value from $type")
        }

        updateState()
        binding.btnTest.setOnClickListener {
            vm.emit(state++)
            updateState()
        }*/

        setContent {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                contentAlignment = Alignment.Center,
            ) {
                ClickableTextTest()
            }
        }
    }

    private fun updateState() {
        binding.tvLabel.text = "State: $state"
    }

    @Composable
    private fun SelectableTextTest() {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(
                space = 4.dp,
                alignment = Alignment.CenterVertically
            )
        ) {
            Text("This is normal text")
            SelectionContainer {
                Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                    Text("This text is selectable")
                    Text("This one too")
                    Text("This one as well")
                    DisableSelection {
                        Text("But not this one")
                        Text("Neither this one")
                    }
                    Text("But again, you can select this one")
                    Text("And this one too")
                }
            }
        }
    }

    @Composable
    private fun ClickableTextTest() {
        val annotatedText = remember {
            buildAnnotatedString {
                append("Click ")

                // We attach this *URL* annotation to the following content
                // until `pop()` is called
                pushStringAnnotation(
                    tag = "URL",
                    annotation = "https://developer.android.com"
                )
                withStyle(
                    style = SpanStyle(
                        color = Color.Blue,
                        fontWeight = FontWeight.Bold
                    )
                ) {
                    append("here")
                }
                pop()
            }
        }

        ClickableText(
            text = annotatedText,
            onClick = { offset ->
                // We check if there is an *URL* annotation attached to the text
                // at the clicked position
                annotatedText.getStringAnnotations(
                    tag = "URL",
                    start = offset,
                    end = offset
                ).firstOrNull()?.let { annotation ->
                    // If yes, we log its value
                    println("Clicked URL: ${annotation.item}")
                }
            }
        )
    }

    @Composable
    private fun RecomposeScopeTest() {
        val recomposeScope = currentRecomposeScope
        SideEffect {
            println("Recomposed Test")
        }
        Box(modifier = Modifier.clickable { recomposeScope.invalidate(); println("Invalidate!") })
    }

    @Composable
    private fun LoggingButton(
        modifier: Modifier = Modifier,
        onClick: () -> Unit,
        content: @Composable RowScope.() -> Unit,
    ) {
        SideEffect {
            println("Recomposed Button")
        }
        Button(
            modifier = modifier,
            onClick = onClick,
            content = content
        )
    }

    @Composable
    private fun LoggingText(
        modifier: Modifier = Modifier,
        text: String,
    ) {
        SideEffect {
            println("Recomposed Text")
        }
        Text(
            modifier = modifier,
            text = text
        )
    }
}
