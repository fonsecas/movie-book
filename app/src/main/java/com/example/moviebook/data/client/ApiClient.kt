package com.example.moviebook.data.client

import com.example.moviebook.data.entity.ApiMovie
import com.example.moviebook.data.util.request.RequestHandler

class ApiClient constructor(
    private val apiService: ApiService
) : RequestHandler() {

    suspend fun getMovieList(): List<ApiMovie>? {
        return makeRequest(apiService.getMovieList())
    }
}