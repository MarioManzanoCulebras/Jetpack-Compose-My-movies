package com.example.mymovies.ui.screens.main

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import coil.annotation.ExperimentalCoilApi
import com.example.mymovies.model.MediaItem

@ExperimentalCoilApi
@ExperimentalFoundationApi
@Composable
fun MainScreen(onMediaItem: (MediaItem) -> Unit) {
    Scaffold(
        topBar = { MainAppBar() })
    { padding ->
        MediaList(
            onMediaClick = onMediaItem,
            modifier = Modifier.padding(padding)
        )
    }
}