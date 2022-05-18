package com.example.moviebook

import android.app.Application
import com.example.moviebook.presentation.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MovieBookApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MovieBookApplication)
            modules(
                listOf(
                    viewModelModule()
                )
            )
        }
    }
}