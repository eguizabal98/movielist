package com.eem.domain.model

data class MoviePageData(
    var page: Int,
    var results: List<MovieItem> = emptyList(),
    var totalPages: Int,
    var totalResults: Int
)
