package com.example.movies.movie.data.remote.dto

import com.example.movies.movie.domain.model.Crew

data class CrewDto(
    val adult: Boolean,
    val credit_id: String,
    val department: String,
    val gender: Int,
    val id: Int,
    val job: String,
    val known_for_department: String,
    val name: String,
    val original_name: String,
    val popularity: Double,
    val profile_path: String?
)
fun CrewDto.toCrew():Crew {
    return Crew(
        original_name = original_name,
        profile_path = profile_path,
    )
}