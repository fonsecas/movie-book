package com.example.moviebook.data.entity

import com.example.moviebook.domain.entity.MovieTrailer
import com.google.gson.annotations.SerializedName

data class ApiMovieTrailerResponse(
    @SerializedName("id") var id: String,
    @SerializedName("results") var movieTrailer: List<MovieTrailer>
) {

    fun toDomainObject() = MovieTrailer(
        id = id,
        key = movieTrailer.first().key
    )
}