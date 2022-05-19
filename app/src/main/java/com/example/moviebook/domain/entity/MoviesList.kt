package com.example.moviebook.domain.entity

import java.io.Serializable

data class MoviesList(
    var page: Int,
    val results: List<Movie>,
    var totalPages: Int,
    var totalResults: Int,
) : Serializable