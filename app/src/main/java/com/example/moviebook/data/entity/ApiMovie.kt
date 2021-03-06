package com.example.moviebook.data.entity

import com.example.moviebook.domain.entity.Movie
import com.google.gson.annotations.SerializedName

data class ApiMovie(
    @SerializedName("popularity") var popularity: Double = 0.0,
    @SerializedName("vote_count") var voteCount: Int = 0,
    @SerializedName("video") var video: Boolean = false,
    @SerializedName("poster_path") var posterPath: String? = "",
    @SerializedName("id") var id: Int = 0,
    @SerializedName("adult") var adult: Boolean = false,
    @SerializedName("backdrop_path") var backdropPath: String? = "",
    @SerializedName("original_language") var originalLanguage: String? = "",
    @SerializedName("original_title") var originalTitle: String? = "",
    @SerializedName("genre_ids") var genreIds: List<Int> = listOf(),
    @SerializedName("title") var title: String = "",
    @SerializedName("vote_average") var voteAverage: Double = 0.0,
    @SerializedName("overview") var overview: String? = "",
    @SerializedName("release_date") var releaseDate: String? = ""
) {

    fun toDomainObject() = Movie(
        id = id,
        popularity = popularity,
        voteCount = voteCount,
        video = video,
        posterPath = posterPath ?: "",
        adult = adult,
        backdropPath = backdropPath ?: "",
        originalLanguage = originalLanguage ?: "",
        originalTitle = originalTitle ?: "",
        genreIds = genreIds,
        title = title,
        voteAverage = voteAverage,
        overview = overview ?: "",
        releaseDate = releaseDate
    )
}