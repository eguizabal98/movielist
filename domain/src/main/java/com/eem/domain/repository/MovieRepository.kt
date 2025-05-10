package com.eem.domain.repository

import com.eem.domain.model.MoviePageData

interface MovieRepository {
    suspend fun getNowPlayingMovies(page: Int): MoviePageData?
}
