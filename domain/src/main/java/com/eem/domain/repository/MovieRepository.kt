package com.eem.domain.repository

import com.eem.domain.model.FavoriteMovie
import com.eem.domain.model.MoviePageData
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
    suspend fun getNowPlayingMovies(page: Int): MoviePageData?
    suspend fun getFavoriteMovies(): Flow<List<FavoriteMovie>>
    suspend fun addFavoriteMovie(movie: FavoriteMovie)
    suspend fun deleteFavoriteMovie(movieId: Long)
}
