package com.eem.data.repository

import com.eem.data.api.MoviesApi
import com.eem.data.database.dao.FavoriteDao
import com.eem.data.database.entity.toDomain
import com.eem.data.database.entity.toEntity
import com.eem.data.dto.toDomain
import com.eem.domain.model.FavoriteMovie
import com.eem.domain.model.MoviePageData
import com.eem.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class MovieRepositoryImpl constructor(
    private val moviesApi: MoviesApi,
    private val favoriteDao: FavoriteDao,
) : MovieRepository {
    override suspend fun getNowPlayingMovies(page: Int): MoviePageData? {
        val response = moviesApi.getNowPlayingMovies(DEFAULT_LANGUAGE, page)

        return if (response.isSuccessful) {
            response.body()?.toDomain()
        } else {
            null
        }
    }

    override suspend fun getFavoriteMovies(): Flow<List<FavoriteMovie>> {
        return favoriteDao.getAll().map { list -> list.map { it.toDomain() } }
    }

    override suspend fun addFavoriteMovie(movie: FavoriteMovie) {
        favoriteDao.insert(movie.toEntity())
    }

    override suspend fun deleteFavoriteMovie(movieId: Long) {
        favoriteDao.delete(movieId)
    }

    companion object {
        private const val DEFAULT_LANGUAGE = "EN"
    }
}
