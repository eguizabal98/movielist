package com.eem.movielist.features.movielist.view.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.eem.movielist.ui.theme.MovieListTheme

@Composable
fun MoviePoster(movieImageUrl: String) {
    var containerWidth by remember { mutableIntStateOf(0) }
    // proportional Height 2:3
    val dynamicHeight = containerWidth.pxToDp() * MOVIE_CARD_PROPORTION

    var isLoading by remember { mutableStateOf(true) }

    Box(
        modifier =
            Modifier
                .fillMaxWidth()
                .height(dynamicHeight)
                .clip(RoundedCornerShape(12.dp))
                .background(Color.DarkGray)
                .onSizeChanged {
                    containerWidth = it.width
                },
    ) {
        AsyncImage(
            model = movieImageUrl,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier =
                Modifier
                    .fillMaxSize()
                    .testTag("poster_image"),
            onSuccess = { isLoading = true },
            onError = { isLoading = true },
        )
    }
}

@Composable
fun Int.pxToDp() = with(LocalDensity.current) { this@pxToDp.toDp() }

@Composable
@Preview
fun MoviePosterPreview() {
    MovieListTheme {
        MoviePoster(movieImageUrl = "")
    }
}

private const val MOVIE_CARD_PROPORTION = 1.66f
