package com.example.moviebook.data.client

import com.example.moviebook.data.entity.ApiMovie
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("fruit")
    suspend fun getMovieList(): Response<List<ApiMovie>>
}