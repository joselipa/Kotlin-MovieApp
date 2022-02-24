package com.example.movies.movie.data.remote.dto

import com.example.movies.movie.domain.model.MovieDetail

data class MovieDetailDto(
    val cast: List<CastDto>,
    val crew: List<CrewDto>,
    val id: Int
)
fun MovieDetailDto.toMovieDetail(): MovieDetail{
    return MovieDetail(
        id=id,
        cast = cast.map { castDto -> castDto.toCast() },
        crew = crew.map { crewDto -> crewDto.toCrew() }
    )
}