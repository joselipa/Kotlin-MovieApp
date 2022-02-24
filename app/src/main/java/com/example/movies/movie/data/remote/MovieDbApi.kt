package com.example.movies.movie.data.remote

import com.example.movies.movie.data.remote.dto.MovieDetailDto
import com.example.movies.movie.data.remote.dto.ResponseMovieNowPlaying
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieDbApi {
    @GET("3/movie/now_playing")
    suspend fun getMoviesNowPlaying(
        @Query("api_key")api_key:String,
        @Query("page")page:String,
        @Query("language")language:String
    ): ResponseMovieNowPlaying

    @GET("3/movie/{movieId}/credits")
    suspend fun getMovieDetail(
        @Path("movieId") movieId:String,
        @Query("api_key") api_key: String
    ): MovieDetailDto
}