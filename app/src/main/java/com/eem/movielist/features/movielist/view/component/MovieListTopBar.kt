package com.eem.movielist.features.movielist.view.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.eem.movielist.R
import com.eem.movielist.ui.theme.MovieListTheme

@Composable
fun MovieListTopBar(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            stringResource(R.string.now_playing_movies),
            style = MaterialTheme.typography.titleLarge
        )
        IconButton(onClick = { /*TODO*/ }, modifier = Modifier.testTag("settings_button")) {
            Icon(
                Icons.Rounded.Settings,
                contentDescription = null
            )
        }
    }
}

@Composable
@Preview(showBackground = true, device = "id:pixel_8", showSystemUi = false)
fun MovieListTopBarPreview() {
    MovieListTheme {
        MovieListTopBar()
    }
}
