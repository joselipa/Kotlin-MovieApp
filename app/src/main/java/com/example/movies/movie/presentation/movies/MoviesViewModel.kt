package com.example.movies.movie.presentation.movies

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movies.CharactersListQuery
import com.example.movies.common.Constants
import com.example.movies.common.Resource
import com.example.movies.movie.data.remote.RickyApi
import com.example.movies.movie.data.repository.CharacterImpl
import com.example.movies.movie.domain.repository.CharacterRepo
import com.example.movies.movie.domain.user_case.getCharacters.GetCharactersUseCase
import com.example.movies.movie.domain.user_case.get_movies_now_playing.GetMoviesNowPlaying
import com.example.movies.type.Character
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(
    private val getMoviesNowPlayingUseCase: GetMoviesNowPlaying,
    private val getCharactersUseCase : GetCharactersUseCase,
):ViewModel() {
    private val _state = mutableStateOf(MoviesNowPlayingState())
    private val _state1 = mutableStateOf(CharacterState())
    val state: State<MoviesNowPlayingState> = _state
    val state1: State<CharacterState> = _state1

    init {
        getMoviesNowPlaying()
        getCharacters()
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
    private fun getCharacters(){
        viewModelScope.launch {
            when (val result = getCharactersUseCase()){
                is Resource.Success->{
                    val results = result.data?.data?.characters?.results

                    _state1.value = CharacterState(characters = results as List<CharactersListQuery.Result>)

                }
                is Resource.Loading->{
                    _state1.value = CharacterState(isLoading = true)
                }
                is Resource.Error->{
                    _state1.value = CharacterState(error = result.message?:"An unexpected error occurred")
                }
            }
        }
    }
}