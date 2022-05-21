package com.example.moviebook.presentation.di

import com.example.moviebook.presentation.view.home.MainViewModel
import com.example.moviebook.presentation.view.home.detail.MovieDetailViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel {
        MainViewModel(get())
    }
    viewModel {
        MovieDetailViewModel(get())
    }
}