package com.example.moviebook.domain.interector

import com.example.moviebook.domain.boundary.MovieRepository

class GetMovieList constructor(
    private val repository: MovieRepository
) {

    suspend fun execute() = repository.getMovieList()
}

