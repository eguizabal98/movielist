package com.eem.domain.interactor

import com.eem.domain.model.FavoriteMovie
import kotlinx.coroutines.flow.Flow

interface GetFavoriteMovieUseCase {
    suspend fun getFavoriteMovies(): Flow<List<FavoriteMovie>>
}
