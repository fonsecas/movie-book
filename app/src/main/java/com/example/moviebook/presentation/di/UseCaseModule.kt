package com.example.moviebook.presentation.di

import com.example.moviebook.domain.interector.GetMovieList
import org.koin.dsl.module

val useCaseModule = module {

    single {
        GetMovieList(get())
    }

}