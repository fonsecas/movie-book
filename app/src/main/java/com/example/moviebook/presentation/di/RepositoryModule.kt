package com.example.moviebook.presentation.di

import com.example.moviebook.data.repository.DefaultMovieRepository
import com.example.moviebook.domain.boundary.MovieRepository
import org.koin.dsl.module

val repositoryModule = module {

    single {
        DefaultMovieRepository(get()) as MovieRepository
    }
}