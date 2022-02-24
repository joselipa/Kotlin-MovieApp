package com.example.movies.movie.domain.repository

import com.example.movies.movie.data.remote.dto.MovieDetailDto
import com.example.movies.movie.data.remote.dto.ResponseMovieNowPlaying

interface MovieRepository {
    suspend fun getMoviesNowPlaying(api_key:String, page:String, language:String): ResponseMovieNowPlaying
    suspend fun getDetailMovie(api_key: String, movieId: String) : MovieDetailDto
}