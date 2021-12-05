package com.example.mymovies

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.lightColors
import coil.annotation.ExperimentalCoilApi
import com.example.mymovies.ui.navigation.Navigation
import com.example.mymovies.ui.theme.MyMoviesTheme
import com.example.mymovies.ui.theme.Shapes
import com.example.mymovies.ui.theme.Typography

@ExperimentalFoundationApi
@ExperimentalCoilApi
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
           MyMoviesTheme {
                Navigation()
            }
        }
    }
}