package com.eem.domain.model

data class MovieItem(
    var id: Long,
    var originalTitle: String? = null,
    var title: String? = null,
    var backdropUrl: String? = null,
    var posterUrl: String? = null,
    var overview: String? = null,
    var popularity: Double? = null,
    var voteAverage: Double? = null,
    var voteCount: Int? = null
)
