package com.example.moviebook.presentation.di

import com.example.moviebook.domain.interector.GetMovieList
import com.example.moviebook.domain.interector.GetMovieTrailer
import com.example.moviebook.domain.interector.IGetMovieList
import org.koin.dsl.module

val useCaseModule = module {

    single {
        GetMovieList(get()) as IGetMovieList
    }

    single {
        GetMovieTrailer(get())
    }

}