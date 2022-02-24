package com.example.movies.movie.presentation.movies.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.movies.movie.domain.model.Movie

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CardMovie(
    movie: Movie,
    onItemClick: (Movie)->Unit
){

    Card(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth(),
        elevation = 8.dp,
        onClick = { onItemClick(movie) }
    ) {
        Box(modifier = Modifier.height(200.dp)){
            Image(
                painter = rememberImagePainter(movie.poster_path),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
            Box(modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color.Black
                        ),
                        startY = 300f
                    )
                ))
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp),
                contentAlignment = Alignment.BottomCenter
            ){
                Text(
                    text = movie.title,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Start,
                    fontSize = 16.sp,
                    color = Color(0xFFFFFFFF),
                )
            }

        }
    }
}