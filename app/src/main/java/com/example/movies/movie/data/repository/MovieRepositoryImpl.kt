package com.example.movies.movie.data.repository

import com.example.movies.movie.data.remote.MovieDbApi
import com.example.movies.movie.data.remote.dto.ResponseMovieNowPlaying
import com.example.movies.movie.domain.repository.MovieRepository
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor (
    private val api: MovieDbApi
):MovieRepository{
    override suspend fun getMoviesNowPlaying(api_key:String, page:String, language:String): ResponseMovieNowPlaying {
        return api.getMoviesNowPlaying(api_key = api_key, page = page, language = language)
    }
}