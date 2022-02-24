package com.example.movies.movie.presentation.detail_movie

import androidx.compose.foundation.layout.Box
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.movies.movie.presentation.movies.MoviesViewModel

@Composable
fun MovieDetailScreen(
    viewModel: MovieDetailViewModel = hiltViewModel(),
    ){
    val state = viewModel.state.value
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "MOVIES") },
                elevation = 0.dp
            )
        }
    ){

    }
}