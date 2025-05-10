package com.eem.movielist.features.movielist.view.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.eem.domain.model.MovieItem
import com.eem.movielist.ui.theme.MovieListTheme

@Composable
fun MovieCardInfo(
    modifier: Modifier = Modifier,
    movieItem: MovieItem? = null,
    isFavorite: Boolean = false,
    onFavoriteClick: (Boolean, MovieItem) -> Unit = { _, _ -> },
) {
    Row(
        modifier =
            modifier
                .clip(ShapeDefaults.Small)
                .border(
                    border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline),
                    shape = ShapeDefaults.Small,
                )
                .padding(16.dp),
    ) {
        Column(
            modifier = Modifier.weight(3f),
        ) {
            movieItem?.posterUrl?.let { MoviePoster(it) }
        }
        Column(
            modifier =
                Modifier
                    .weight(6f)
                    .padding(start = 16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            Text(text = movieItem?.title.orEmpty(), style = MaterialTheme.typography.titleMedium)
            Text(
                text = movieItem?.overview.orEmpty(),
                maxLines = 7,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.bodyMedium,
            )
        }
        Column(
            modifier = Modifier.weight(1f),
        ) {
            IconButton(onClick = {
                movieItem?.let {
                    onFavoriteClick(!isFavorite, it)
                }
            }) {
                if (isFavorite) {
                    Icon(
                        Icons.Rounded.Favorite,
                        contentDescription = null,
                    )
                } else {
                    Icon(
                        Icons.Rounded.FavoriteBorder,
                        contentDescription = null,
                    )
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun MovieCardInfoPreview() {
    MovieListTheme {
        MovieCardInfo(
            modifier = Modifier.fillMaxWidth(),
            movieItem =
                MovieItem(
                    id = 1,
                    title = "Movie Title",
                    overview = "Movie Overview",
                ),
        )
    }
}
