package com.example.moviebook.data.client

import com.example.moviebook.data.entity.ApiMovieTrailerResponse
import com.example.moviebook.data.entity.ApiMoviesList
import com.example.moviebook.data.util.request.RequestHandler

class ApiClient constructor(
    private val apiService: ApiService
) : RequestHandler() {

    suspend fun getMovieList(): ApiMoviesList? {
        return makeRequest(apiService.getMovieList())
    }

    suspend fun getMovieTrailer(movieId: Int?): ApiMovieTrailerResponse? {
        return makeRequest(apiService.getMovieTrailer(movieId))
    }
}