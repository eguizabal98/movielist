package com.eem.movielist.features.movielist.viewmodel

import androidx.lifecycle.ViewModel
import com.eem.domain.interactor.GetNowPlayingMoviesUseCase
import com.eem.movielist.features.movielist.view.state.MovieListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class MovieListViewModel @Inject constructor(
    private val getNowPlayingMoviesUseCase: GetNowPlayingMoviesUseCase,
) : ViewModel() {

    private val internalState = MutableStateFlow(MovieListState())
    val state: StateFlow<MovieListState> = internalState.asStateFlow()

    suspend fun getNowPlayingMovies() {
        val moviesResult = getNowPlayingMoviesUseCase.getNowPlayingMovies(1)

        moviesResult?.let {
            internalState.value =
                internalState.value.copy(nowPlayingMovies = it.results, filterMovies = it.results)
        }
    }

    fun updateSearchQuery(query: String) {
        internalState.value = internalState.value.copy(
            searchQuery = query,
            filterMovies = if (query.isEmpty()) {
                internalState.value.nowPlayingMovies
            } else {
                internalState.value.nowPlayingMovies.filter {
                    it.title?.contains(query, ignoreCase = true) == true
                }
            }
        )
    }
}
