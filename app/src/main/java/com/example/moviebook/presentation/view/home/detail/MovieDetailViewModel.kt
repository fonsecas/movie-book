package com.example.moviebook.presentation.view.home.detail


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.moviebook.domain.entity.MovieTrailer
import com.example.moviebook.domain.interector.GetMovieTrailer
import com.example.moviebook.presentation.util.base.BaseViewModel

class MovieDetailViewModel constructor(
    private val getMovieTrailer: GetMovieTrailer
) : BaseViewModel() {

    val movieTrailer: LiveData<MovieTrailer> get() = _movieTrailer

    private val _movieTrailer by lazy { MutableLiveData<MovieTrailer>() }


    fun getMovieTrailer(movieTrailerId: Int?) {
        launchDataLoad(onFailure = ::onFailure) {
            getMovieTrailer.getMovieTrailer(movieTrailerId).apply {
                _movieTrailer.value = this
            }
        }
    }

    private fun onFailure(throwable: Throwable) {
        throwable
    }
}
