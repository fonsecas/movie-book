package com.example.moviebook.presentation.view.home


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.moviebook.domain.entity.Movie
import com.example.moviebook.domain.entity.MoviesList
import com.example.moviebook.domain.interector.GetMovieList
import com.framework.desafio.android.presentation.util.base.BaseViewModel

class MainViewModel constructor(
    private val getMovieList: GetMovieList
) : BaseViewModel() {

    val users: LiveData<MoviesList> get() = _users

    private val _users by lazy { MutableLiveData<MoviesList>() }

    init {
        getMovieList()
    }

    private fun getMovieList() {
        launchDataLoad(onFailure = ::onFailure) {
               _users.value = getMovieList.execute()
        }
    }

    private fun onFailure(throwable: Throwable) {
        throwable
    }
}
