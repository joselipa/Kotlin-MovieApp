package com.example.movies.movie.presentation.detail_movie

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.movies.movie.domain.user_case.get_movie.GetMovieUseCase
import com.example.movies.movie.presentation.movies.MoviesNowPlayingState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import androidx.lifecycle.viewModelScope
import com.example.movies.common.Constants
import com.example.movies.common.Resource
import com.example.movies.movie.domain.model.Movie
import com.example.movies.movie.domain.model.MovieDetail
import kotlinx.coroutines.launch
import retrofit2.Response

@HiltViewModel
class MovieDetailViewModel @Inject constructor(
    private val getMovieUseCase: GetMovieUseCase,
    savedStateHandle: SavedStateHandle
):ViewModel(){
    private val _state = mutableStateOf(MovieDetailState())
    val state: State<MovieDetailState> = _state

    init {
        savedStateHandle.get<String>(Constants.MOVIE_ID)?.let { movieId->
            getMovieDetail( movieId = movieId )
        }
    }

    private fun getMovieDetail(api_key:String=Constants.API_KEY, movieId:String){
        viewModelScope.launch {
            when(val result=getMovieUseCase(api_key = api_key, movieId = movieId)){
                is Resource.Success->{
                    _state.value = MovieDetailState(movie = result.data)
                }
                is Resource.Loading->{
                    _state.value = MovieDetailState(isLoading = true)
                }
                is Resource.Error->{
                    _state.value = MovieDetailState(error = result.message?:"An unexpected error occurred")
                }
            }
        }
    }

}

