package com.eem.domain.di

import com.eem.domain.interactor.AddFavoriteMovieUseCase
import com.eem.domain.interactor.AddFavoriteMovieUseCaseImpl
import com.eem.domain.interactor.DeleteFavoriteMovieUseCase
import com.eem.domain.interactor.DeleteFavoriteMovieUseCaseImpl
import com.eem.domain.interactor.GetFavoriteMovieUseCase
import com.eem.domain.interactor.GetFavoriteMovieUseCaseImpl
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

    @Provides
    fun provideAddFavoriteMovieUseCase(movieRepository: MovieRepository): AddFavoriteMovieUseCase {
        return AddFavoriteMovieUseCaseImpl(movieRepository)
    }

    @Provides
    fun provideDeleteFavoriteMovieUseCase(movieRepository: MovieRepository): DeleteFavoriteMovieUseCase {
        return DeleteFavoriteMovieUseCaseImpl(movieRepository)
    }

    @Provides
    fun provideGetFavoriteMovieUseCase(movieRepository: MovieRepository): GetFavoriteMovieUseCase {
        return GetFavoriteMovieUseCaseImpl(movieRepository)
    }
}
