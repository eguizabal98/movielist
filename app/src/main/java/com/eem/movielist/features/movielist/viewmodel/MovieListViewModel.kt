package com.eem.movielist.features.movielist.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eem.domain.interactor.AddFavoriteMovieUseCase
import com.eem.domain.interactor.DeleteFavoriteMovieUseCase
import com.eem.domain.interactor.GetFavoriteMovieUseCase
import com.eem.domain.interactor.GetNowPlayingMoviesUseCase
import com.eem.domain.model.FavoriteMovie
import com.eem.movielist.features.movielist.view.state.MovieListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieListViewModel @Inject constructor(
    private val getNowPlayingMoviesUseCase: GetNowPlayingMoviesUseCase,
    private val getFavoriteMovieUseCase: GetFavoriteMovieUseCase,
    private val addFavoriteMovieUseCase: AddFavoriteMovieUseCase,
    private val deleteFavoriteMovieUseCase: DeleteFavoriteMovieUseCase
) : ViewModel() {

    private val internalState = MutableStateFlow(MovieListState())
    val state: StateFlow<MovieListState> = internalState.asStateFlow()

    suspend fun getNowPlayingMovies() {
        val moviesResult = getNowPlayingMoviesUseCase.getNowPlayingMovies(1)

        moviesResult?.let {
            internalState.value =
                internalState.value.copy(nowPlayingMovies = it.results, filterMovies = it.results)
        }
        setFavoriteListener()
    }

    private suspend fun setFavoriteListener() {
        getFavoriteMovieUseCase.getFavoriteMovies().collect {
            internalState.value = internalState.value.copy(favoriteMovies = it)
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

    fun deleteFavoriteMovie(movieId: Long) {
        viewModelScope.launch {
            deleteFavoriteMovieUseCase.deleteFavoriteMovies(movieId)
        }
    }

    fun addFavoriteMovie(movieId: Long, title: String) {
        viewModelScope.launch {
            addFavoriteMovieUseCase.addFavoriteMovies(FavoriteMovie(movieId, title))
        }
    }
}
