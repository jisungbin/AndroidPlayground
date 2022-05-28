@file:OptIn(ExperimentalTextApi::class)

package land.sungbin.androidplayground

import androidx.compose.foundation.text.ClickableText
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withAnnotation
import androidx.compose.ui.text.withStyle

@Composable
fun DummyClickableText() {
    val toast = rememberToast()

    val annotatedText = buildAnnotatedString {
        append("클릭 가능한 Text")
    }

    ClickableText(
        text = annotatedText,
        onClick = { offset ->
            toast("클릭된 오프셋: $offset")
        }
    )

}

@Composable
fun DummyClickableTextWithAnnotated() {
    val toast = rememberToast()

    val annotatedText = buildAnnotatedString {
        pushStringAnnotation(
            tag = "URL",
            annotation = "https://sungbin.land"
        )
        pushStyle(
            style = SpanStyle(
                color = Color.Green,
                fontWeight = FontWeight.Bold
            )
        )
        append("성빈랜드")
        pop()
        pop()
        append(" 바로가기")
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

@Composable
fun DummyClickableTextWithAnnotated2() {
    val toast = rememberToast()

    val annotatedText = buildAnnotatedString {
        withAnnotation(
            tag = "URL",
            annotation = "https://sungbin.land"
        ) {
            withStyle(
                style = SpanStyle(
                    color = Color.Green,
                    fontWeight = FontWeight.Bold
                )
            ) {
                append("성빈랜드")
            }
        }
        append(" 바로가기")
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