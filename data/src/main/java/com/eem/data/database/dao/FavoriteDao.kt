package com.eem.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.eem.data.database.entity.FavoriteEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteDao {
    @Query("SELECT * FROM FavoriteEntity")
    fun getAll(): Flow<List<FavoriteEntity>>

    @Insert
    suspend fun insert(favorite: FavoriteEntity)

    @Query("DELETE FROM FavoriteEntity WHERE id = :movieId")
    suspend fun delete(movieId: Long)
}
