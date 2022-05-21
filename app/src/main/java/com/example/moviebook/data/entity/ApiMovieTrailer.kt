package com.example.moviebook.data.entity

import com.example.moviebook.domain.entity.MovieTrailer
import com.google.gson.annotations.SerializedName

data class ApiMovieTrailer(
    @SerializedName("id") var id: String,
    @SerializedName("results") var key: String
) {

    fun toDomainObject() = MovieTrailer(
        id = id,
        key = key
    )
}