package com.eem.domain.di

import com.eem.domain.interactor.GetNowPlayingMoviesUseCase
import com.eem.domain.interactor.GetNowPlayingMoviesUseCaseImpl
import com.eem.domain.repository.MovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object UseCasesModule {
    @Provides
    fun provideGetNowPlayingMoviesUseCase(movieRepository: MovieRepository): GetNowPlayingMoviesUseCase {
        return GetNowPlayingMoviesUseCaseImpl(movieRepository)
    }
}
