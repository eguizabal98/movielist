package com.eem.movielist.features.movielist.view.component

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performTextInput
import com.eem.movielist.ui.theme.MovieListTheme
import org.junit.Rule
import org.junit.Test

class MovieListSearchBarTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun movieListSearchBar_displaysPlaceholderAndAcceptsInput() {
        val placeholder = "Search movies"
        val inputText = "Inception"

        composeTestRule.setContent {
            MovieListTheme {
                MovieListSearchBar(
                    query = "",
                    onQueryChange = {},
                    placeholder = placeholder,
                )
            }
        }

        // Check the placeholder is shown
        composeTestRule
            .onNodeWithText(placeholder)
            .assertIsDisplayed()

        composeTestRule
            .onNodeWithTag("search_bar")
            .performTextInput(inputText)
    }
}
