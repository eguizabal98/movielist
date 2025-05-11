package com.eem.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.eem.domain.model.FavoriteMovie

@Entity
data class FavoriteEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Long? = null,
    val title: String
)

fun FavoriteEntity.toDomain() = FavoriteMovie(
    id = id ?: 0,
    title = title
)

fun FavoriteMovie.toEntity() = FavoriteEntity(
    id = id,
    title = title
)
