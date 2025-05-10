package com.eem.data.repository

import com.eem.data.api.MoviesApi
import com.eem.data.dto.toDomain
import com.eem.domain.model.MoviePageData
import com.eem.domain.repository.MovieRepository

class MovieRepositoryImpl constructor(private val moviesApi: MoviesApi) : MovieRepository {
    override suspend fun getNowPlayingMovies(page: Int): MoviePageData? {
        val response = moviesApi.getNowPlayingMovies(DEFAULT_LANGUAGE, page)

        return if (response.isSuccessful) {
            response.body()?.toDomain()
        } else {
            null
        }
    }

    companion object {
        private const val DEFAULT_LANGUAGE = "EN"
    }
}
