package com.example.moviebook.presentation.view.home

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.moviebook.domain.entity.Movie

class MovieListAdapter(
    private val onMovieClickedCallback: (Movie) -> Unit
) : ListAdapter<Movie, MovieListIViewHolder>(DiffUtilCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieListIViewHolder {
        return MovieListIViewHolder.inflate(parent)
    }

    override fun onBindViewHolder(holder: MovieListIViewHolder, position: Int) {
        holder.bind(
            currentList[position],
            onMovieClickedCallback
        )
    }

    override fun getItemCount(): Int = currentList.size

    companion object DiffUtilCallback : DiffUtil.ItemCallback<Movie>() {
        override fun areItemsTheSame(oldItem: Movie, newItem: Movie) = oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Movie, newItem: Movie) = oldItem == newItem
    }
}