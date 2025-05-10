package com.eem.domain.interactor

import com.eem.domain.model.FavoriteMovie

interface AddFavoriteMovieUseCase {
    suspend fun addFavoriteMovies(movie: FavoriteMovie)
}
