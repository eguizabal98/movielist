package com.eem.data.di

import android.content.Context
import androidx.room.Room
import com.eem.data.database.MovieDataBase
import com.eem.data.database.dao.FavoriteDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalModule {
    @Singleton
    @Provides
    fun provideLocalDataBase(
        @ApplicationContext appContext: Context,
    ): MovieDataBase {
        val roomInstance =
            Room.databaseBuilder(
                appContext,
                MovieDataBase::class.java,
                MovieDataBase.DATABASE_NAME,
            )
        return roomInstance
            .fallbackToDestructiveMigration(true)
            .build()
    }

    @Singleton
    @Provides
    fun provideFavoriteMoviesDao(movieDataBase: MovieDataBase): FavoriteDao =
        movieDataBase.favoriteDao()
}
