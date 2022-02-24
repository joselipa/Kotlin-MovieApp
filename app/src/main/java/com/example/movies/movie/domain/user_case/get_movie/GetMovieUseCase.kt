package com.example.movies.movie.domain.user_case.get_movie

import com.example.movies.common.Resource
import com.example.movies.movie.data.remote.dto.toMovieDetail
import com.example.movies.movie.domain.model.MovieDetail
import com.example.movies.movie.domain.repository.MovieRepository
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetMovieUseCase @Inject constructor(
    private val repository: MovieRepository
){
    suspend operator fun invoke(api_key:String, movieId:String) : Resource<MovieDetail> =
        try{
            Resource.Loading<MovieRepository>()
            val result = repository.getDetailMovie(api_key = api_key, movieId = movieId)
            Resource.Success<MovieDetail>(result.toMovieDetail())
        }
        catch(e:HttpException){
            Resource.Error<MovieDetail>(e.localizedMessage?:"An unexpected error occurred")
        }
        catch(e:IOException){
            Resource.Error<MovieDetail>("Couldn't reach server. Check your internet connection")
        }

}