package com.example.moviebook.data.client

import com.example.moviebook.data.entity.ApiMoviesList
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("movie/popular")
    suspend fun getMovieList(): Response<ApiMoviesList>
}