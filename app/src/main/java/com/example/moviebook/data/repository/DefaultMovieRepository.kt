package com.example.moviebook.data.repository

import com.example.moviebook.data.client.ApiClient
import com.example.moviebook.domain.boundary.MovieRepository
import com.example.moviebook.domain.entity.Movie

class DefaultMovieRepository constructor(
    private val apiClient: ApiClient
) : MovieRepository {

    override suspend fun getMovieList(): List<Movie>? {
        return apiClient.getMovieList()?.map { it.toDomainObject() }
    }
}