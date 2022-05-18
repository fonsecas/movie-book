package com.example.moviebook.data.entity

import com.example.moviebook.domain.entity.Movie
import com.google.gson.annotations.SerializedName

data class ApiMovie(
    @SerializedName("img") val img: String,
    @SerializedName("name") val name: String,
    @SerializedName("id") val id: Int,
) {

    fun toDomainObject() = Movie(
        id = id,
        img = img,
        name = name
    )
}