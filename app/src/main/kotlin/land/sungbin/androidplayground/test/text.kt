@file:OptIn(ExperimentalTextApi::class)

package land.sungbin.androidplayground.test

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.selection.DisableSelection
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withAnnotation
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import land.sungbin.androidplayground.rememberToast

@Composable
fun SelectableTextTest() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(
            space = 30.dp,
            alignment = Alignment.CenterVertically
        )
    ) {
        Text("선택 불가능한 Text")
        SelectionContainer {
            Column(verticalArrangement = Arrangement.spacedBy(30.dp)) {
                Text("선택 가능한 Text - 1")
                Text("선택 가능한 Text - 2")
            }
        }
    }
}

@Composable
fun SelectableWithDisableSelectionTextTest() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(
            space = 30.dp,
            alignment = Alignment.CenterVertically
        )
    ) {
        Text("선택 불가능한 Text")
        SelectionContainer {
            Column(
                verticalArrangement = Arrangement.spacedBy(30.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("선택 가능한 Text - 1")
                Text("선택 가능한 Text - 2")
                DisableSelection {
                    ProvideTextStyle(LocalTextStyle.current.copy(fontSize = 25.sp)) {
                        Text("다시 선택 불가능한 Text - 1")
                        Text("다시 선택 불가능한 Text - 2")
                    }
                }
                Text("선택 가능한 Text - 3")
                Text("선택 가능한 Text - 4")
            }
        }
    }
}

@Composable
fun ClickableTextTest() {
    val toast = rememberToast()
    val localTextStyle = LocalTextStyle.current
    val annotatedText = remember {
        buildAnnotatedString {
            withStyle(style = localTextStyle.toSpanStyle()) {
                append("클릭 가능한 Text")
            }
        }
    }

    ClickableText(
        text = annotatedText,
        onClick = { offset ->
            toast("클릭된 오프셋: $offset")
        }
    )
}

@Composable
fun ClickableTextWithAnnotatedTest() {
    val toast = rememberToast()
    val localTextStyle = LocalTextStyle.current
    val annotatedText = remember {
        buildAnnotatedString {
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
                annotation = "https://sungbin.land"
            ) {
                withStyle(
                    style = localTextStyle.copy(
                        color = Color.Green,
                        fontWeight = FontWeight.Bold
                    ).toSpanStyle()
                ) {
                    append("성빈랜드")
                }
            }

            withStyle(localTextStyle.toSpanStyle()) {
                append(" 바로가기")
            }
        }
    }

    ClickableText(
        text = annotatedText,
        onClick = { offset ->
            annotatedText.getStringAnnotations(
                tag = "URL",
                start = offset,
                end = offset
            ).firstOrNull()?.let { annotation ->
                val message = """
                    클릭된 URL: ${annotation.item}
                    클릭된 오프셋: $offset
                """.trimIndent()
                toast(message)
            }
        }
    )
}