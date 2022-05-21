package com.example.moviebook.domain.interector

import com.example.moviebook.domain.boundary.MovieRepository
import com.example.moviebook.domain.entity.MovieTrailer

interface IGetMovieTrailer {
    suspend fun getMovieTrailer(movieId: Int?): MovieTrailer?
}

class GetMovieTrailer(private val repository: MovieRepository) : IGetMovieTrailer {
    override suspend fun getMovieTrailer(movieId: Int?): MovieTrailer? {
        return repository.getMovieTrailer(movieId)
    }
}

