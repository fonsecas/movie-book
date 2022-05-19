package com.example.moviebook.data.client

import com.example.moviebook.data.entity.ApiMovie
import com.example.moviebook.data.entity.ApiMoviesList
import com.example.moviebook.data.util.request.RequestHandler
import com.example.moviebook.domain.entity.MoviesList

class ApiClient constructor(
    private val apiService: ApiService
) : RequestHandler() {

    suspend fun getMovieList(): ApiMoviesList? {
        return makeRequest(apiService.getMovieList())
    }
}