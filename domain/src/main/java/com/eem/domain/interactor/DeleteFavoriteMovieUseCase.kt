package com.eem.domain.interactor

interface DeleteFavoriteMovieUseCase {
    suspend fun deleteFavoriteMovies(id: Long)
}
