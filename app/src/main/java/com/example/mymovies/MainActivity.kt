package com.example.mymovies

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayCircleOutline
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.mymovies.MediaItem.Type
import com.example.mymovies.ui.theme.MyMoviesTheme

@ExperimentalFoundationApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyMoviesTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    val (value, onValueChange) =  rememberSaveable {mutableStateOf("")}
                    StateSample(
                        value = value,
                        onValueChange = onValueChange
                    )
                }
            }
        }
    }
}

@Composable
fun StateSample(value: String, onValueChange : (String) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(64.dp),
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = value,
            onValueChange = { onValueChange(it) },
            modifier = Modifier.fillMaxWidth()
        )
        Text(
            text = value,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Yellow)
                .padding(8.dp)
        )
        Button(
            onClick = { onValueChange("") },
            modifier = Modifier.fillMaxWidth(),
            enabled = value.isNotEmpty()
        ) {
            Text(text = "Clear")
        }
    }
}

@ExperimentalFoundationApi
//@Preview
@Composable
fun MediaList() {
    LazyVerticalGrid(
        contentPadding = PaddingValues(2.dp),
        cells = GridCells.Adaptive(150.dp)
    ) {
        items(getMedia()) { item ->
            MediaListItem(item, Modifier.padding(2.dp))
        }
    }
}

//@Preview(showBackground = true)
@Composable
fun MediaListItem(item: MediaItem, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
    ) {
        Box(modifier = Modifier
            .height(200.dp)
            .fillMaxWidth(),
        contentAlignment = Alignment.Center){
            Image(
                painter = rememberImagePainter(
                    data = item.thumb),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
            if (item.type == Type.VIDEO) {
                Icon(
                    imageVector = Icons.Default.PlayCircleOutline,
                    contentDescription = null,
                    modifier = Modifier.size(92.dp),
                    tint = Color.White
                )
            }
        }
        Box(contentAlignment= Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .background(color = MaterialTheme.colors.secondary)
                .padding(16.dp)) {
            Text(text = item.title,
            style = MaterialTheme.typography.h6)
        }
    }
}

//@Preview(showBackground = true, widthDp = 200, heightDp = 100)
@Composable
fun ButtonText() {
    Box(modifier = Modifier.fillMaxSize(),
    contentAlignment = Alignment.Center){
        Text(
            text = "Hello World"
        )
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(text = "Hello $name!", modifier = modifier)
}