package com.eem.data.dto

import com.eem.domain.model.MoviePageData
import com.google.gson.annotations.SerializedName

data class MoviePageDataDto(
    @SerializedName("page")
    var page: Int? = null,
    @SerializedName("results")
    var results: List<MovieItemDto> = emptyList(),
    @SerializedName("total_pages")
    var totalPages: Int? = null,
    @SerializedName("total_results")
    var totalResults: Int? = null
)

fun MoviePageDataDto.toDomain(): MoviePageData {
    return MoviePageData(
        page = page ?: 0,
        results = results.map { it.toDomain() },
        totalPages = totalPages ?: 0,
        totalResults = totalResults ?: 0
    )
}
