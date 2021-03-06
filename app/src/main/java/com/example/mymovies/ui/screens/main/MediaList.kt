package com.example.mymovies.ui.screens.main

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import com.example.mymovies.R
import com.example.mymovies.model.MediaItem
import com.example.mymovies.model.getMedia
import com.example.mymovies.ui.screens.common.Thumb

@ExperimentalCoilApi
@ExperimentalFoundationApi
@Composable
fun MediaList(onMediaClick: (MediaItem) -> Unit, modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        contentPadding = PaddingValues(dimensionResource(id = R.dimen.padding_xsmall)),
        cells = GridCells.Adaptive(dimensionResource(id = R.dimen.cell_min_width)),
        modifier = modifier
    ) {
        items(getMedia()) { item ->
            MediaListItem(
                item,
                onClick = { onMediaClick(item) },
                Modifier.padding(dimensionResource(id = R.dimen.padding_xsmall))
            )
        }
    }
}

//@Preview(showBackground = true)
@ExperimentalCoilApi
@Composable
fun MediaListItem(mediaItem: MediaItem,
                  onClick: () -> Unit,
                  modifier: Modifier = Modifier) {

    Card(
        modifier = modifier
        .clickable (onClick = onClick),
    elevation = 0.dp,
    border = BorderStroke(1.dp, Color.LightGray),
        backgroundColor = MaterialTheme.colors.primary,
        contentColor = MaterialTheme.colors.secondary
    ) {
        Column{
            Thumb(mediaItem)
            Title(mediaItem)
        }
    }
}

@Composable
private fun Title(mediaItem: MediaItem){
    Box(contentAlignment= Alignment.Center,
        modifier = Modifier
            .fillMaxWidth()
            //.background(color = MaterialTheme.colors.secondary)
            .padding(dimensionResource(id = R.dimen.padding_medium))) {
        Text(text = mediaItem.title,
            style = MaterialTheme.typography.h6)
    }
}

@ExperimentalCoilApi
@ExperimentalFoundationApi
@Preview(showBackground = true)
@Composable
fun MediaListPreview() {
    //MediaList()
}