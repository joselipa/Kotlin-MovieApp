package com.example.movies.movie.presentation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.compose.material.Surface
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.movies.movie.presentation.detail_movie.MovieDetailScreen
import com.example.movies.movie.presentation.movies.MoviesScreen
import com.example.movies.movie.presentation.ui.theme.MovieAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieAppTheme {
                Surface(color= MaterialTheme.colors.background){
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.MoviesScreen.route
                    ){
                        composable(route = Screen.MoviesScreen.route){
                            MoviesScreen(navController = navController)
                        }
                        composable(route = Screen.MovieDetailScreen.route+ "/{movieId}"){
                            MovieDetailScreen()
                        }
                    }
                }
            }
        }
    }
}