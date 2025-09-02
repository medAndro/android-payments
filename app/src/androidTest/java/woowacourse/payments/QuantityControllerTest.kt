package woowacourse.payments

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsEnabled
import androidx.compose.ui.test.assertIsNotEnabled
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.junit.Rule
import org.junit.Test

class QuantityControllerTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun `초기_상태는_1이다`() {
        composeTestRule.setContent {
            QuantityController()
        }
        composeTestRule.onNodeWithText("1").assertIsDisplayed()
    }

    @Test
    fun `상태가_1이면_빼기_버튼은_비활성화되어야_한다`() {
        composeTestRule.setContent {
            QuantityController()
        }
        composeTestRule.onNodeWithText("-").assertIsDisplayed()
        composeTestRule.onNodeWithText("-").assertIsNotEnabled()
    }

    @Test
    fun `더하기_버튼_누르면_숫자가_증가한다`() {
        composeTestRule.setContent {
            QuantityController()
        }
        composeTestRule.onNodeWithText("+").performClick()
        composeTestRule.onNodeWithText("2").assertIsDisplayed()
    }

    @Test
    fun `숫자가_1이_아니면_빼기_버튼은_활성화되야한다`() {
        composeTestRule.setContent {
            QuantityController()
        }
        composeTestRule.onNodeWithText("+").performClick()
        composeTestRule.onNodeWithText("-").assertIsEnabled()
    }
}

@Preview(showBackground = true)
@Composable
fun QuantityController() {
    var quantity by remember { mutableStateOf(1) }
    Row(verticalAlignment = Alignment.CenterVertically) {
        Button(
            onClick = { quantity-- },
            enabled = quantity > 1,
        ) {
            Text(text = "-")
        }

        Text(
            text = quantity.toString(),
            modifier = Modifier.padding(horizontal = 16.dp),
        )

        Button(
            onClick = { quantity++ },
            enabled = true,
        ) {
            Text(text = "+")
        }
    }
}
