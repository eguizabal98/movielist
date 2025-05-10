package com.eem.movielist.features.movielist.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.eem.domain.model.FavoriteMovie
import com.eem.domain.model.MovieItem
import com.eem.movielist.R
import com.eem.movielist.features.movielist.view.component.MovieCardInfo
import com.eem.movielist.features.movielist.view.component.MovieListSearchBar
import com.eem.movielist.features.movielist.view.component.MovieListTopBar
import com.eem.movielist.features.movielist.viewmodel.MovieListViewModel
import com.eem.movielist.ui.theme.MovieListTheme

@Composable
fun MovieListScreen(viewModel: MovieListViewModel = hiltViewModel()) {
    val state by viewModel.state.collectAsState()

    LaunchedEffect(key1 = Unit) {
        viewModel.getNowPlayingMovies()
    }

    MovieListContent(
        movies = state.filterMovies,
        favoriteMovies = state.favoriteMovies,
        query = state.searchQuery,
        onFilterChange = viewModel::updateSearchQuery,
        addFavorite = viewModel::addFavoriteMovie,
        removeFavorite = viewModel::deleteFavoriteMovie,
    )
}

@Composable
fun MovieListContent(
    movies: List<MovieItem>,
    favoriteMovies: List<FavoriteMovie> = emptyList(),
    query: String? = "",
    onFilterChange: (String) -> Unit = {},
    addFavorite: (Long, String) -> Unit = { _, _ -> },
    removeFavorite: (Long) -> Unit = {},
) {
    LazyColumn(
        modifier =
            Modifier
                .fillMaxSize()
                .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        item {
            MovieListTopBar(modifier = Modifier.fillMaxWidth())
        }
        item {
            MovieListSearchBar(
                query = query.orEmpty(),
                onQueryChange = {
                    onFilterChange(it)
                },
                modifier = Modifier.fillMaxWidth(),
                placeholder = stringResource(R.string.search_movie),
            )
        }
        items(movies) { item ->
            MovieCardInfo(
                movieItem = item,
                modifier = Modifier.fillMaxWidth(),
                isFavorite = favoriteMovies.any { it.id == item.id },
                onFavoriteClick = { state, movie ->
                    if (state) {
                        addFavorite(movie.id, item.title.orEmpty())
                    } else {
                        removeFavorite(movie.id)
                    }
                },
            )
        }
    }
}

@Composable
@Preview
fun MovieListScreenPreview() {
    MovieListTheme {
        MovieListContent(
            movies =
                listOf(
                    MovieItem(
                        id = 1,
                        title = "Movie 1",
                        overview = "Overview 1",
                    ),
                    MovieItem(
                        id = 2,
                        title = "Movie 2",
                        overview = "Overview 2",
                    ),
                ),
        )
    }
}
