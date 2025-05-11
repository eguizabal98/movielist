package com.eem.movielist.features.movielist.view.component

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import com.eem.movielist.ui.theme.MovieListTheme
import org.junit.Rule
import org.junit.Test

class MoviePosterTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun moviePoster_rendersAsyncImageWithTag() {
        val dummyImageUrl = "https://example.com/poster.jpg"

        composeTestRule.setContent {
            MovieListTheme {
                MoviePoster(movieImageUrl = dummyImageUrl)
            }
        }

        // Verify that the AsyncImage is shown with the correct test tag
        composeTestRule
            .onNodeWithTag("poster_image")
            .assertExists()
            .assertIsDisplayed()
    }
}
