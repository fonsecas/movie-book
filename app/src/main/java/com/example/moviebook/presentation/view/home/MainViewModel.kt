package com.example.moviebook.presentation.view.home


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.moviebook.domain.entity.Movie
import com.example.moviebook.domain.interector.GetMovieList
import com.framework.desafio.android.presentation.util.base.BaseViewModel

class MainViewModel  : BaseViewModel() {

    val users: LiveData<List<Movie?>?> get() = _users

    private val _users by lazy { MutableLiveData<List<Movie?>?>() }

    init {
        //getFruitList()
    }

    private fun getFruitList() {
        launchDataLoad {
         //   _users.value = getMovieList.execute()
        }
    }
}
