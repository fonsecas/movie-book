package com.example.moviebook.domain.interector

import com.example.moviebook.domain.boundary.MovieRepository
import com.example.moviebook.domain.entity.MoviesList

interface IGetMovieList {
    suspend fun getMovieList(): MoviesList?
}

class GetMovieList(private val repository: MovieRepository) : IGetMovieList {
    override suspend fun getMovieList(): MoviesList? {
        return repository.getMovieList()
    }
}

