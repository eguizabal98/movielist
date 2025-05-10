package com.eem.domain.interactor

import com.eem.domain.model.FavoriteMovie
import com.eem.domain.repository.MovieRepository

class AddFavoriteMovieUseCaseImpl(
    private val movieRepository: MovieRepository
) : AddFavoriteMovieUseCase {
    override suspend fun addFavoriteMovies(movie: FavoriteMovie) {
        movieRepository.addFavoriteMovie(movie)
    }
}