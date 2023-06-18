package com.example.newestmoviesapp.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newestmoviesapp.R
import com.example.newestmoviesapp.data.model.Movie
import com.example.newestmoviesapp.databinding.MovieItemBinding

class MovieAdapter(): RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {
    private val movieList = ArrayList<Movie>()

    fun setList(movies:List<Movie>){
        movieList.clear()
        movieList.addAll(movies)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding :MovieItemBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.movie_item,
            parent,
            false
        )
        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(movieList[position])
    }

    override fun getItemCount(): Int {
        return movieList.size
    }
    class MovieViewHolder(val binding:MovieItemBinding):
        RecyclerView.ViewHolder(binding.root){

        fun bind(movie: Movie){
            binding.titleTextView.text = movie.title
            binding.descriptionTextView.text = movie.overview

            val posterURL = "https://image.tmdb.org/t/p/w500/" + movie.posterPath

            //Library used to display the image in Image View
            Glide.with(binding.imageView.context).load(posterURL).into(binding.imageView)
        }
    }
}


