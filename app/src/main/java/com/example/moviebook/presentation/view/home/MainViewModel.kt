package com.example.moviebook.presentation.view.home


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.moviebook.domain.entity.Movie
import com.example.moviebook.domain.interector.IGetMovieList
import com.example.moviebook.presentation.view.home.detail.MovieDetailsNavData
import com.example.moviebook.presentation.util.base.BaseViewModel

class MainViewModel constructor(
    private val getMovieList: IGetMovieList
) : BaseViewModel() {

    val users: LiveData<List<Movie>> get() = _users

    private val _users by lazy { MutableLiveData<List<Movie>>() }

    init {
        getMovieList()
    }

     fun getMovieList() {
        launchDataLoad(onFailure = ::onFailure) {
            getMovieList.getMovieList().apply {
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
