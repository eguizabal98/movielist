package com.eem.movielist.features.movielist.view.state

import com.eem.domain.model.MovieItem

data class MovieListState(
    val nowPlayingMovies: List<MovieItem> = emptyList(),
    val searchQuery: String? = null,
    val filterMovies: List<MovieItem> = emptyList()
)
