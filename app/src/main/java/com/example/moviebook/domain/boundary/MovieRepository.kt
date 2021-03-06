package com.example.moviebook.domain.boundary

import com.example.moviebook.domain.entity.MovieTrailer
import com.example.moviebook.domain.entity.MoviesList

interface MovieRepository {
    suspend fun getMovieList(): MoviesList?
    suspend fun getMovieTrailer(movieId: Int?): MovieTrailer?
}