package com.example.movies.movie.data.di

import com.example.movies.common.Constants
import com.example.movies.movie.data.remote.MovieDbApi
import com.example.movies.movie.data.remote.RickyApi
import com.example.movies.movie.data.repository.CharacterImpl
import com.example.movies.movie.data.repository.MovieRepositoryImpl
import com.example.movies.movie.domain.repository.CharacterRepo
import com.example.movies.movie.domain.repository.MovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModel {

    @Provides
    @Singleton
    fun provideMovieApi():MovieDbApi{
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MovieDbApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCoinRepository(api:MovieDbApi):MovieRepository{
        return MovieRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideCharacterRepo():CharacterRepo{
        val api = RickyApi()
        return CharacterImpl(api)
    }
}