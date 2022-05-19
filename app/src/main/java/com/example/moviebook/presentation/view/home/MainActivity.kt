package com.example.moviebook.presentation.view.home

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.moviebook.R
import com.example.moviebook.databinding.ActivityMainBinding
import com.example.moviebook.domain.entity.Movie
import com.example.moviebook.domain.entity.MoviesList
import com.framework.desafio.android.presentation.util.base.BaseActivity
import com.framework.desafio.android.presentation.util.base.BaseViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity() {

    override val baseViewModel: BaseViewModel get() = _viewModel
    private val _viewModel: MainViewModel by viewModel()

    private lateinit var binding: ActivityMainBinding

            override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
                binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
    }

    override fun subscribeUi() {
        super.subscribeUi()
        _viewModel.users.observe(this, ::onMoviesReceived)
    }

    private fun onMoviesReceived(movieList: MoviesList) {
        val x = movieList
        x
    }
}