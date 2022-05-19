package com.example.moviebook.data.entity

import com.example.moviebook.domain.entity.MoviesList
import com.google.gson.annotations.SerializedName

data class ApiMoviesList(
    @SerializedName("page") val page: Int,
    @SerializedName("total_results") val totalResults: Int,
    @SerializedName("total_pages") val totalPages: Int,
    @SerializedName("results") val movies: List<ApiMovie>
) {

    fun toDomainObject(): MoviesList {
        return MoviesList(
            page = page,
            totalResults = totalResults,
            totalPages = totalPages,
            results = movies.map { it.toDomainObject() }
        )
    }
}