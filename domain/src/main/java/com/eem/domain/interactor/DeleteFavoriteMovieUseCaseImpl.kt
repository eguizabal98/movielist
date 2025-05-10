package com.eem.domain.interactor

import com.eem.domain.repository.MovieRepository

class DeleteFavoriteMovieUseCaseImpl(
    private val movieRepository: MovieRepository,
) : DeleteFavoriteMovieUseCase {
    override suspend fun deleteFavoriteMovies(id: Long) {
        movieRepository.deleteFavoriteMovie(id)
    }
}
