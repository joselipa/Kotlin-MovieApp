package com.example.movies.movie.domain.repository

import com.apollographql.apollo3.api.ApolloResponse
import com.example.movies.CharactersListQuery

interface CharacterRepo {
    suspend fun queryCharactersList(): ApolloResponse<CharactersListQuery.Data>
}