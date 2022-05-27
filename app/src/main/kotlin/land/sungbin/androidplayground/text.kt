package land.sungbin.androidplayground

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.selection.DisableSelection
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withAnnotation
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp

@Composable
fun SelectableTextTest() {
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

@OptIn(ExperimentalTextApi::class)
@Composable
fun ClickableTextTest() {
    val annotatedText = remember {
        buildAnnotatedString {
            append("Click ")

            // We attach this *URL* annotation to the following content
            // until `pop()` is called
            /*pushStringAnnotation(
                tag = "URL",
                annotation = "https://developer.android.com"
            )
            pushStyle(
                style = SpanStyle(
                    color = Color.Blue,
                    fontWeight = FontWeight.Bold
                )
            )
            append("here")
            pop()
            pop()*/

            withAnnotation(
                tag = "URL",
                annotation = "https://developer.android.com"
            ) {
                withStyle(
                    style = SpanStyle(
                        color = Color.Blue,
                        fontWeight = FontWeight.Bold
                    )
                ) {
                    append("here")
                }
            }
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
                println("Clicked offset: $offset")
            }
        }
    )
}