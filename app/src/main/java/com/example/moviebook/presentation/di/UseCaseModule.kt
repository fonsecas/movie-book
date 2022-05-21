package com.example.moviebook.presentation.di

import com.example.moviebook.domain.interector.GetMovieList
import com.example.moviebook.domain.interector.GetMovieTrailer
import org.koin.dsl.module

val useCaseModule = module {

    single {
        GetMovieList(get())
    }

    single {
        GetMovieTrailer(get())
    }

}