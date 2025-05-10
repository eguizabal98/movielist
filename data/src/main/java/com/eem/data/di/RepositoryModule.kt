package com.eem.data.di

import com.eem.data.api.MoviesApi
import com.eem.data.database.dao.FavoriteDao
import com.eem.data.repository.MovieRepositoryImpl
import com.eem.domain.repository.MovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun providesMovieRepository(
        moviesApi: MoviesApi,
        favoriteDao: FavoriteDao,
    ): MovieRepository = MovieRepositoryImpl(moviesApi, favoriteDao)
}
