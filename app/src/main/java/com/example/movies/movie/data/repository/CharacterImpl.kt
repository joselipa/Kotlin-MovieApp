package com.example.movies.movie.data.repository

import com.apollographql.apollo3.api.ApolloResponse
import com.example.movies.CharactersListQuery
import com.example.movies.movie.data.remote.RickyApi
import com.example.movies.movie.domain.repository.CharacterRepo
import javax.inject.Inject

class CharacterImpl(private val api: RickyApi): CharacterRepo{
    override suspend fun queryCharactersList(): ApolloResponse<CharactersListQuery.Data> {
        return api.getApolloClient().query(CharactersListQuery()).execute()
    }
}