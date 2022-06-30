package land.sungbin.androidplayground

import androidx.compose.material.Text
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class ComposeUiTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Before
    fun setup() {
        composeTestRule.mainClock.autoAdvance = false
    }

    @Test
    fun welcome_test() {
        composeTestRule.setContent {
            Text(text = "Welcome")
        }

        composeTestRule
            .onNodeWithText("Welcome")
            .assertIsDisplayed()
    }

    @Test
    fun counter_test() {
        var counter by mutableStateOf(0)
        var lastSeenValue = 0

        composeTestRule.setContent {
            Text(counter.toString())
            SideEffect {
                lastSeenValue = counter
            }
        }

        counter = 1

        lastSeenValue() // 0
        assertFalse(lastSeenValue == 1)
        lastSeenValue() // 0

        composeTestRule.onNodeWithText("1").assertDoesNotExist()
        assertFalse(lastSeenValue == 1) // 0

        composeTestRule.mainClock.advanceTimeByFrame()

        composeTestRule.onNodeWithText("1").assertExists()
        assertTrue(lastSeenValue == 1) // 1
    }
}

private operator fun Any.invoke() {
    println("TestLog: $this")
}