package com.eem.domain.interactor

import com.eem.domain.model.FavoriteMovie
import com.eem.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow

class GetFavoriteMovieUseCaseImpl(
    private val movieRepository: MovieRepository
) : GetFavoriteMovieUseCase {
    override suspend fun getFavoriteMovies(): Flow<List<FavoriteMovie>> {
        return movieRepository.getFavoriteMovies()
    }
}