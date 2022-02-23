package com.example.movies.movie.presentation.movies

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movies.common.Constants
import com.example.movies.common.Resource
import com.example.movies.movie.domain.user_case.get_movies_now_playing.GetMoviesNowPlaying
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(
    private val getMoviesNowPlayingUseCase: GetMoviesNowPlaying
):ViewModel() {
    private val _state = mutableStateOf(MoviesNowPlayingState())
    val state: State<MoviesNowPlayingState> = _state

    init {
        getMoviesNowPlaying()
    }

    private fun getMoviesNowPlaying(api_key:String = Constants.API_KEY, page:String=Constants.PAGE, language:String=Constants.LANGUAGE){
        viewModelScope.launch {
            when (val result = getMoviesNowPlayingUseCase(api_key = api_key, page = page, language = language)){
                is Resource.Success->{
                    _state.value = MoviesNowPlayingState(movies = result.data?: emptyList())
                }
                is Resource.Loading->{
                    _state.value = MoviesNowPlayingState(isLoading = true)
                }
                is Resource.Error->{
                    _state.value = MoviesNowPlayingState(error = result.message?:"An unexpected error occurred")
                }
            }
        }
    }
}