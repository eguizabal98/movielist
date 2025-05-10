package com.eem.domain.interactor

import com.eem.domain.model.MoviePageData

interface GetNowPlayingMoviesUseCase {
    suspend fun getNowPlayingMovies(page: Int): MoviePageData?
}
