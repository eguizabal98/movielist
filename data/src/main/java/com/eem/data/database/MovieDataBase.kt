package com.eem.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.eem.data.database.dao.FavoriteDao
import com.eem.data.database.entity.FavoriteEntity

@Database(
    entities = [
        FavoriteEntity::class,
    ],
    version = 1,
    exportSchema = false,
)
abstract class MovieDataBase : RoomDatabase() {
    abstract fun favoriteDao(): FavoriteDao

    companion object {
        const val DATABASE_NAME = "app_database"
    }
}
