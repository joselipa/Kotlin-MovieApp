package com.example.movies.movie.presentation.detail_movie

import com.example.movies.movie.domain.model.MovieDetail


class MovieDetailState(
    val isLoading: Boolean  = false,
    val movie: MovieDetail? = null,
    val error:String = ""
)