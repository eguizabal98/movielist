package com.eem.domain.interactor

import com.eem.domain.model.MoviePageData
import com.eem.domain.repository.MovieRepository

class GetNowPlayingMoviesUseCaseImpl(private val movieRepository: MovieRepository) :
    GetNowPlayingMoviesUseCase {
    override suspend fun getNowPlayingMovies(page: Int): MoviePageData? {
        return movieRepository.getNowPlayingMovies(page)
    }
}
