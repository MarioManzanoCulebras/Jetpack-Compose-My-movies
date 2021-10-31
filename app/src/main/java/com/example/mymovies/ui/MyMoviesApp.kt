package com.example.mymovies.ui

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import com.example.mymovies.ui.theme.MyMoviesTheme

@Composable
fun MyMoviesApp(content: @Composable () -> Unit){
    MyMoviesTheme {
        // A surface container using the 'background' color from the theme
        Surface(color = MaterialTheme.colors.background) {
            content ()
        }
    }
}