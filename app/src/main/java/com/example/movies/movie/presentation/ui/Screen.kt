package com.example.movies.movie.presentation.ui

sealed class Screen(val route:String) {
    object MoviesScreen: Screen("movies_screen")
    object MovieDetailScreen: Screen("movie_detail_screen")
}