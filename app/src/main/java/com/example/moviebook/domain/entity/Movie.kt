package com.example.moviebook.domain.entity

import java.io.Serializable

data class Movie(
    val id: Int,
    val img: String,
    val name: String
) : Serializable