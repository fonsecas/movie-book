package com.example.moviebook.presentation.view.home.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.example.moviebook.R
import com.example.moviebook.databinding.ActivityMovieDetailsBinding
import com.example.moviebook.domain.entity.Movie
import com.framework.desafio.android.presentation.util.base.BaseActivity
import com.framework.desafio.android.presentation.util.base.BaseViewModel
import org.koin.android.viewmodel.ext.android.viewModel


class MovieDetailActivity : BaseActivity() {

    override val baseViewModel: BaseViewModel get() = _viewModel
    private val _viewModel: MovieDetailViewModel by viewModel()

    private lateinit var binding: ActivityMovieDetailsBinding

    private val intentMovie by lazy { intent.getSerializableExtra(MOVIE_EXTRA) as Movie }
    private var movie: Movie? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_movie_details)
        movie = intentMovie
        setupUi()
    }

    private fun setupUi() {
        binding.title.text = movie?.title
        binding.overview.text = movie?.overview
        Glide
            .with(binding.root.context)
            .load("https://image.tmdb.org/t/p/original/${movie?.posterPath}")
            .thumbnail()
            .into(binding.banner)
        binding.backButton.setOnClickListener { finish() }
    }

    companion object {
        private const val MOVIE_EXTRA = "MOVIE_EXTRA"

        fun createIntent(context: Context, movie: Movie): Intent {
            return Intent(context, MovieDetailActivity::class.java).apply {
                putExtra(MOVIE_EXTRA, movie)
            }
        }
    }

}