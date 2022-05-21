package com.example.moviebook.presentation.view.home

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
import com.example.moviebook.R
import com.example.moviebook.databinding.ActivityMainBinding
import com.example.moviebook.domain.entity.Movie
import com.framework.desafio.android.presentation.util.base.BaseActivity
import com.framework.desafio.android.presentation.util.base.BaseViewModel
import org.koin.android.viewmodel.ext.android.viewModel


class MainActivity : BaseActivity() {

    override val baseViewModel: BaseViewModel get() = _viewModel
    private val _viewModel: MainViewModel by viewModel()

    private lateinit var binding: ActivityMainBinding

    private lateinit var adapter: MovieListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setupAdapter()
    }

    override fun subscribeUi() {
        super.subscribeUi()
        _viewModel.users.observe(this, ::onMoviesReceived)
        _viewModel.placeholder.observe(this) { binding.placeholderView.setPlaceholder(it) }
    }

    private fun setupAdapter() {
        adapter = MovieListAdapter(
            _viewModel::onMovieSelected
        )
        val layoutManager = GridLayoutManager(this, 2)
        layoutManager.spanSizeLookup = object : SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                return if (position == 0) 1 else 1
            }
        }

        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.adapter = adapter
    }

    private fun onMoviesReceived(movieList: List<Movie>) {
        adapter.submitList(movieList)
    }
}