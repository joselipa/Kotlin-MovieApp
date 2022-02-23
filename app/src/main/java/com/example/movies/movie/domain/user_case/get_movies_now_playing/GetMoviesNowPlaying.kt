package com.example.movies.movie.domain.user_case.get_movies_now_playing

import com.example.movies.common.Resource
import com.example.movies.movie.data.remote.dto.toCoin
import com.example.movies.movie.domain.model.Movie
import com.example.movies.movie.domain.repository.MovieRepository
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetMoviesNowPlaying @Inject constructor(
    private val repository : MovieRepository
){
    suspend operator fun invoke(api_key:String, page:String,language:String): Resource<List<Movie>> =
        try{
            Resource.Loading<List<Movie>>()
            val response = repository.getMoviesNowPlaying(api_key = api_key, page=page, language = language)
            Resource.Success<List<Movie>>(response.results.map {
                it.toCoin()
            })
        }
        catch (e:HttpException){
            println(e.message())
            println(e.response())
            Resource.Error<List<Movie>>(e.localizedMessage?:"An unexpected error")
        }
        catch (e: IOException){
            Resource.Error<List<Movie>>("Couldn't reach server. Check your internet connection")
        }
}