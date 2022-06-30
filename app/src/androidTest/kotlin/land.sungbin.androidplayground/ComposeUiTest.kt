package land.sungbin.androidplayground

import androidx.compose.material.Text
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import org.junit.Rule
import org.junit.Test

class ComposeUiTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun onCreate() {
        composeTestRule.setContent {
            Text(text = "Welcome")
        }

        composeTestRule.onNodeWithText("Welcome").assertIsDisplayed()
    }
}