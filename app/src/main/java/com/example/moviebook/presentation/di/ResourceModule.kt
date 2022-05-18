package com.example.moviebook.presentation.di

import com.example.moviebook.presentation.util.error.ErrorHandler
import org.koin.dsl.module

fun resourceModule() = module {

    single {
        ErrorHandler(get())
    }

}
