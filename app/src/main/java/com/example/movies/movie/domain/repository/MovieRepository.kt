package com.example.movies.movie.domain.repository

import com.example.movies.movie.data.remote.dto.ResponseMovieNowPlaying

interface MovieRepository {
    suspend fun getMoviesNowPlaying(api_key:String, page:String, language:String): ResponseMovieNowPlaying
}