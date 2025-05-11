package com.eem.movielist.features.movielist.view.component

import androidx.compose.ui.test.assertHasClickAction
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.eem.domain.model.MovieItem
import com.eem.movielist.ui.theme.MovieListTheme
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

class MovieCardInfoTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun movieCardInfo_displaysMovieData_andTogglesFavorite() {
        val testMovie =
            MovieItem(
                id = 123,
                title = "The Matrix",
                overview = "A computer hacker learns about the true nature of his reality.",
            )
        var clickedFavorite: Boolean? = null
        var clickedMovie: MovieItem? = null

        composeTestRule.setContent {
            MovieListTheme {
                MovieCardInfo(
                    movieItem = testMovie,
                    isFavorite = false,
                    onFavoriteClick = { isFav, movie ->
                        clickedFavorite = isFav
                        clickedMovie = movie
                    },
                )
            }
        }

        // Check title and overview
        composeTestRule.onNodeWithText("The Matrix").assertIsDisplayed()
        composeTestRule.onNodeWithText("A computer hacker learns about the true nature of his reality.")
            .assertIsDisplayed()

        // Check that the button exists and is clickable
        composeTestRule.onNodeWithTag("favorite_button")
            .assertExists()
            .assertHasClickAction()
            .performClick()

        // Validate callback behavior
        assertEquals(true, clickedFavorite)
        assertEquals(testMovie, clickedMovie)
    }
}
