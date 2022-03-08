package com.example.movies.movie.domain.user_case.getCharacters

import coil.network.HttpException
import com.apollographql.apollo3.api.ApolloResponse
import com.example.movies.CharactersListQuery
import com.example.movies.common.Resource
import com.example.movies.movie.domain.repository.CharacterRepo
import com.example.movies.movie.domain.repository.MovieRepository
import java.io.IOException
import javax.inject.Inject

class GetCharactersUseCase @Inject constructor(
    private val repository: CharacterRepo
){
    suspend operator fun invoke(): Resource<ApolloResponse<CharactersListQuery.Data>> =
        try {
            Resource.Loading<ApolloResponse<CharactersListQuery.Data>>()
            val result = repository.queryCharactersList()
            Resource.Success<ApolloResponse<CharactersListQuery.Data>>(result)
        }
        catch(e: HttpException){
            Resource.Error<ApolloResponse<CharactersListQuery.Data>>(e.localizedMessage?:"An unexpected error occurred")
        }
        catch(e: IOException){
            Resource.Error<ApolloResponse<CharactersListQuery.Data>>("Couldn't reach server. Check your internet connection")
        }
}
