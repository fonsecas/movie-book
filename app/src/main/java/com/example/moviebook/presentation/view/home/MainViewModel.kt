package com.example.moviebook.presentation.view.home


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.moviebook.domain.entity.Movie
import com.example.moviebook.domain.interector.GetMovieList
import com.example.moviebook.presentation.view.home.detail.MovieDetailsNavData
import com.framework.desafio.android.presentation.util.base.BaseViewModel

class MainViewModel constructor(
    private val getMovieList: GetMovieList
) : BaseViewModel() {

    val users: LiveData<List<Movie>> get() = _users

    private val _users by lazy { MutableLiveData<List<Movie>>() }

    init {
        getMovieList()
    }

    private fun getMovieList() {
        launchDataLoad(onFailure = ::onFailure) {
            getMovieList.execute().apply {
                _users.value = this?.results
            }
        }
    }

    private fun onFailure(throwable: Throwable) {
        throwable
    }

    fun onMovieSelected(movie: Movie) {
        goTo(MovieDetailsNavData(movie))
    }
}
