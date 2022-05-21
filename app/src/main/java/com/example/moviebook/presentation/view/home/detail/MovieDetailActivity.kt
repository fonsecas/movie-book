package com.example.moviebook.presentation.view.home.detail

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.example.moviebook.R
import com.example.moviebook.databinding.ActivityMovieDetailsBinding
import com.example.moviebook.domain.entity.Movie
import com.example.moviebook.presentation.util.resource.IMAGE_URL_ORIGINAL
import com.example.moviebook.presentation.util.resource.IMAGE_URL_W500
import com.example.moviebook.presentation.util.resource.TMDB_MOVIE_URL
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
        with(binding) {
            movie.let {
                title.text = movie?.title
                overview.text = movie?.overview
                year.text = getYearDate(movie?.releaseDate)
                rate.text = movie?.voteAverage.toString()

                Glide
                    .with(root.context)
                    .load("${IMAGE_URL_ORIGINAL}${movie?.posterPath}")
                    .thumbnail()
                    .into(banner)
                Glide
                    .with(root.context)
                    .load("${IMAGE_URL_W500}${movie?.backdropPath}")
                    .thumbnail()
                    .into(imgBackground)
            }

            backButton.setOnClickListener { finish() }
            detailButton.setOnClickListener { onDetailClicked(movie?.id) }
            shareButton.setOnClickListener { onShareClicked(movie?.id) }
        }

    }


    private fun getYearDate(date: String?): String {
        val list = date?.split("-")
        return list?.get(0) ?: ""
    }

    private fun onDetailClicked(movieId: Int?) {
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("${TMDB_MOVIE_URL}${movieId}"))
        startActivity(browserIntent)
    }

    private fun onShareClicked(movieId: Int?) {
        startActivity(
            Intent.createChooser(
                Intent().apply {
                    action = Intent.ACTION_SEND
                    putExtra(Intent.EXTRA_TEXT, "${TMDB_MOVIE_URL}${movieId}")
                    type = "text/plain"
                },
                getString(R.string.share_movie)
            )
        )
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