package com.example.mymovies.ui.screens.detail

import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import coil.annotation.ExperimentalCoilApi
import com.example.mymovies.model.getMedia
import com.example.mymovies.ui.screens.common.Thumb
import com.example.mymovies.ui.screens.shared.ArrowBackIcon

@ExperimentalCoilApi
@Composable
fun DetailScreen(mediaId: Int, onUpClick : () -> Unit) {
    val mediaItem = remember { getMedia().first(){it.id == mediaId} }
    Scaffold (
        topBar = { TopAppBar(title = { Text(text = mediaItem.title) }, navigationIcon = {
            ArrowBackIcon(onUpClick)
        })}
            ){ padding ->
        Thumb(mediaItem = mediaItem, Modifier.padding(padding))
    }
}
