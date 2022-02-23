package com.example.movies.movie.data.remote.dto

data class ResponseMovieNowPlaying(
    val dates: Dates,
    val page: Int,
    val results: List<MovieDto>,
    val total_pages: Int,
    val total_results: Int
)
