package com.example.moviebook.presentation.view.home.detail

import android.content.Context
import com.example.moviebook.domain.entity.Movie
import com.example.moviebook.presentation.util.navigation.NavData

class MovieDetailsNavData(
    private val movie: Movie
) : NavData {

    override fun navigate(context: Context) {
        context.startActivity(MovieDetailActivity.createIntent(context, movie))
    }
}