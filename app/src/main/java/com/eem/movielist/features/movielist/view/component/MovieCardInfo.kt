package com.eem.movielist.features.movielist.view.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.eem.movielist.ui.theme.MovieListTheme

@Composable
fun MovieCardInfo(
    modifier: Modifier = Modifier,
    imageUrl: String? = null,
    title: String = "",
    overview: String = "",
    rate: Int = 0
) {
    Row(
        modifier = modifier.padding(16.dp)
    ) {
        Column(
            modifier = Modifier.weight(3f)
        ) {

        }
        Column(
            modifier = Modifier.weight(6f)
        ) {
            Text(title)
            Text(overview)
        }
        Column(
            modifier = Modifier.weight(1f)
        ) {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    Icons.Rounded.FavoriteBorder,
                    contentDescription = null
                )
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
            imageUrl = null,
            title = "Title",
            overview = "Overview",
            rate = 5
        )
    }
}
