package com.eem.movielist.features.movielist.view.component

import androidx.compose.ui.test.assertHasClickAction
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsEnabled
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import com.eem.movielist.ui.theme.MovieListTheme
import org.junit.Rule
import org.junit.Test

class MovieListTopBarTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun movieListTopBar_displaysTitleAndSettingsButton() {
        composeTestRule.setContent {
            MovieListTheme {
                MovieListTopBar()
            }
        }

        // Check that the title is displayed
        composeTestRule
            .onNodeWithText("Now Playing Movies")
            .assertIsDisplayed()

        // Check that the settings button exists and is clickable
        composeTestRule
            .onNodeWithTag("settings_button")
            .assertExists()
            .assertIsEnabled()
            .assertHasClickAction()
    }
}
