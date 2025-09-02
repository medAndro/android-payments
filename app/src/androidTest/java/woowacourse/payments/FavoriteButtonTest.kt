package woowacourse.payments

import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class FavoriteButtonTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Before
    fun setUp() {
        composeTestRule.setContent {
            FavoriteButton()
        }
    }

    @Test
    fun `초기에는_빈_하트가_나온다`() {
        composeTestRule.onNodeWithContentDescription("좋지않아요 아이콘").assertIsDisplayed()
    }

    @Test
    fun `버튼을_누르면_꽉찬_하트가_나온다`() {
        composeTestRule.onNodeWithText("좋아요").performClick()
        composeTestRule.onNodeWithContentDescription("좋지않아요 아이콘").assertDoesNotExist()
        composeTestRule.onNodeWithContentDescription("좋아요 아이콘").assertIsDisplayed()
    }
}

@Composable
fun FavoriteButton() {
    var isFavorite: Boolean by remember { mutableStateOf(false) }
    Button(onClick = {
        isFavorite = !isFavorite
    }) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            when (isFavorite) {
                true -> {
                    Icon(
                        imageVector = Icons.Filled.Favorite,
                        contentDescription = "좋아요 아이콘",
                        tint = Color.Red,
                    )
                }

                false -> {
                    Icon(
                        imageVector = Icons.Filled.FavoriteBorder,
                        contentDescription = "좋지않아요 아이콘",
                        tint = Color.Black,
                    )
                }
            }

            Text(text = "좋아요")
        }
    }
}
