package com.example.moviebook.data.client

import com.example.moviebook.data.entity.ApiMovieTrailerResponse
import com.example.moviebook.data.entity.ApiMoviesList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("movie/popular")
    suspend fun getMovieList(): Response<ApiMoviesList>

    @GET("movie/{id}/videos")
    suspend fun getMovieTrailer(@Path("id") movieId: Int?): Response<ApiMovieTrailerResponse>
}