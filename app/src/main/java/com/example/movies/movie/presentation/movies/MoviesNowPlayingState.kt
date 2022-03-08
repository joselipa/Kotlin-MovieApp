package com.example.movies.movie.presentation.movies

import com.example.movies.CharactersListQuery
import com.example.movies.movie.domain.model.Movie
import com.example.movies.type.Character

data class MoviesNowPlayingState(
    val isLoading: Boolean  = false,
    val movies: List<Movie> = emptyList(),
    val error:String = ""
)

data class CharacterState(
    val isLoading: Boolean  = false,
    val characters: List<CharactersListQuery.Result> = emptyList(),
    val error:String = ""
)
