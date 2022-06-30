@file:Suppress("UnusedImport")

package land.sungbin.androidplayground

import androidx.compose.ui.test.SemanticsNodeInteraction
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import land.sungbin.androidplayground.view.MainActivity
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class ComposeUiTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    private lateinit var textInputField: SemanticsNodeInteraction
    private lateinit var confirmTextInputField: SemanticsNodeInteraction
    private lateinit var checkButton: SemanticsNodeInteraction
    private lateinit var checkResultText: SemanticsNodeInteraction

    private val hello = "Hello"
    private val world = "World"

    private lateinit var checkFailText: String
    private lateinit var checkSuccessText: String

    @Before
    fun init() {
        with(composeTestRule) {
            textInputField = onNodeWithTag(
                activity.getString(R.string.input_text_tag)
            )
            confirmTextInputField = onNodeWithTag(
                activity.getString(R.string.confirm_text_tag)
            )
            checkButton = onNodeWithText(
                activity.getString(R.string.check_text)
            )
            checkResultText = onNodeWithTag(
                activity.getString(R.string.check_result)
            )
            checkFailText = activity.getString(R.string.fail)
            checkSuccessText = activity.getString(R.string.pass)
        }
    }

    @Test
    fun `non-matching_text_confirm_fails`() {
        textInputField.performTextInput(hello)
        confirmTextInputField.performTextInput(world)
        checkButton.performClick()

        checkResultText.assertTextEquals(checkFailText)
    }

    @Test
    fun matching_text_confirm_success() {
        textInputField.performTextInput(hello)
        confirmTextInputField.performTextInput(hello)
        checkButton.performClick()

        checkResultText.assertTextEquals(checkSuccessText)
    }
}
