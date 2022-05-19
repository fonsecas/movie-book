package com.example.moviebook.presentation.view.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moviebook.databinding.ListItemMovieBinding
import com.example.moviebook.domain.entity.Movie

class MovieListIViewHolder(
    private val binding: ListItemMovieBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(movie: Movie) {
        binding.rate.text = movie.voteAverage.toString()
        binding.tittle.text = movie.originalTitle
        Glide
            .with(binding.root.context)
            .load("https://image.tmdb.org/t/p/original/${movie.posterPath}")
            .thumbnail()
            .into(binding.picture)
    }

    companion object {
        fun inflate(parent: ViewGroup) = MovieListIViewHolder(
            ListItemMovieBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }
}