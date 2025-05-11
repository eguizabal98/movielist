package com.eem.domain.repository

import com.eem.domain.model.FavoriteMovie
import com.eem.domain.model.MoviePageData
import kotlinx.coroutines.flow.Flow

/**
 * Implementation of [MovieRepository] that handles data operations by interacting with
 * a remote API and a local database.
 *
 * @property moviesApi The remote API service for fetching movie data.
 * @property favoriteDao The DAO for performing local database operations related to favorite movies.
 */
interface MovieRepository {
    /**
     * Fetches a paginated list of "Now Playing" movies from the remote API.
     *
     * @param page The page number to retrieve.
     * @return A [MoviePageData] object if the request was successful, otherwise `null`.
     */
    suspend fun getNowPlayingMovies(page: Int): MoviePageData?

    /**
     * Retrieves the list of locally stored favorite movies as a [Flow].
     *
     * @return A [Flow] emitting lists of [FavoriteMovie]s from the local database.
     */
    suspend fun getFavoriteMovies(): Flow<List<FavoriteMovie>>

    /**
     * Adds a movie to the list of favorites in the local database.
     *
     * @param movie The [FavoriteMovie] to be added.
     */
    suspend fun addFavoriteMovie(movie: FavoriteMovie)

    /**
     * Removes a movie from the list of favorites in the local database.
     *
     * @param movieId The ID of the movie to remove from favorites.
     */
    suspend fun deleteFavoriteMovie(movieId: Long)
}
