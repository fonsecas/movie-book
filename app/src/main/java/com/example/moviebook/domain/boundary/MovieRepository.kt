package com.example.moviebook.domain.boundary

import com.example.moviebook.domain.entity.Movie

interface MovieRepository {
    suspend fun getMovieList(): List<Movie?>?
}