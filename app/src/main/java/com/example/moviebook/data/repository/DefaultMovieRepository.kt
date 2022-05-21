package com.example.moviebook.data.repository

import com.example.moviebook.data.client.ApiClient
import com.example.moviebook.domain.boundary.MovieRepository
import com.example.moviebook.domain.entity.MovieTrailer
import com.example.moviebook.domain.entity.MoviesList

class DefaultMovieRepository constructor(
    private val apiClient: ApiClient
) : MovieRepository {

    override suspend fun getMovieList(): MoviesList? {
        return apiClient.getMovieList()?.toDomainObject()
    }

    override suspend fun getMovieTrailer(movieId: Int?): MovieTrailer? {
        return apiClient.getMovieTrailer(movieId)?.toDomainObject()
    }
}
