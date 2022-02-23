package com.example.movies.movie.presentation.movies

import com.example.movies.movie.domain.model.Movie

data class MoviesNowPlayingState(
    val isLoading: Boolean  = false,
    val movies: List<Movie> = emptyList(),
    val error:String = ""
)
