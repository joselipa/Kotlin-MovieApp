package com.example.movies.movie.domain.model

data class MovieDetail(
    val cast: List<Cast>,
    val crew: List<Crew>,
    val id: Int
)
