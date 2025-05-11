package com.eem.data.dto

import com.eem.data.util.toImageData
import com.eem.domain.model.MovieItem
import com.google.gson.annotations.SerializedName

data class MovieItemDto(
    @SerializedName("id")
    var id: Long? = null,
    @SerializedName("adult")
    var adult: Boolean? = null,
    @SerializedName("backdrop_path")
    var backdropPath: String? = null,
    @SerializedName("genre_ids")
    var genreIds: List<Int> = listOf(),
    @SerializedName("original_language")
    var originalLanguage: String? = null,
    @SerializedName("original_title")
    var originalTitle: String? = null,
    @SerializedName("overview")
    var overview: String? = null,
    @SerializedName("popularity")
    var popularity: Double? = null,
    @SerializedName("poster_path")
    var posterPath: String? = null,
    @SerializedName("release_date")
    var releaseDate: String? = null,
    @SerializedName("title")
    var title: String? = null,
    @SerializedName("video")
    var video: Boolean? = null,
    @SerializedName("vote_average")
    var voteAverage: Double? = null,
    @SerializedName("vote_count")
    var voteCount: Int? = null,
)

fun MovieItemDto.toDomain(): MovieItem {
    return MovieItem(
        id = id ?: 0,
        originalTitle = originalTitle.orEmpty(),
        title = title.orEmpty(),
        backdropUrl = backdropPath.toImageData(),
        posterUrl = posterPath.toImageData(),
        overview = overview.orEmpty(),
        popularity = popularity ?: 0.0,
        voteAverage = voteAverage ?: 0.0,
        voteCount = voteCount ?: 0,
    )
}
