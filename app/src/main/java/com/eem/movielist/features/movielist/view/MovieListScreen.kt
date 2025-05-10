package com.eem.movielist.features.movielist.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.eem.movielist.R
import com.eem.movielist.features.movielist.view.component.MovieCardInfo
import com.eem.movielist.features.movielist.view.component.MovieListSearchBar
import com.eem.movielist.features.movielist.view.component.MovieListTopBar
import com.eem.movielist.ui.theme.MovieListTheme

@Composable
fun MovieListScreen() {
    MovieListContent()
}

@Composable
fun MovieListContent() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(state = rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        MovieListTopBar(modifier = Modifier.fillMaxWidth())
        MovieListSearchBar(
            query = "",
            onQueryChange = {},
            modifier = Modifier.fillMaxWidth(),
            placeholder = stringResource(R.string.search_movie),
        )
        Column {
            repeat(10) { repetition ->
                MovieCardInfo(
                    title = "Movie Title $repetition",
                    overview = "Movie Description $repetition",
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}

@Composable
@Preview
fun MovieListScreenPreview() {
    MovieListTheme {
        MovieListContent()
    }
}
