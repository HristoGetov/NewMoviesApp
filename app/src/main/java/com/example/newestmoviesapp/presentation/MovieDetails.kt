package com.example.newestmoviesapp.presentation

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.example.newestmoviesapp.R
import com.example.newestmoviesapp.databinding.ActivityMainBinding
import com.example.newestmoviesapp.databinding.ActivityMovieDetailsBinding

class MovieDetails : AppCompatActivity() {
        private lateinit var binding:ActivityMovieDetailsBinding

        @SuppressLint("SetTextI18n")
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = DataBindingUtil.setContentView(this, R.layout.activity_movie_details)

            val mainActivity = intent
            val title = mainActivity.getStringExtra("title")
            val picPath = mainActivity.getStringExtra("image")
            val lang = mainActivity.getStringExtra("language")
            val rating = mainActivity.getDoubleExtra("rating",0.0)
            val count = mainActivity.getIntExtra("count",0)
            val desc = mainActivity.getStringExtra("description")
            val releaseDate = mainActivity.getStringExtra("releaseDate")

            binding.apply {
                titleTextView.text = title
                movieLanguage.text = "Language: $lang"
                ratingText.text = "Rating: $rating"
                numberOfVotes.text = "Votes: $count"
                descriptionTextView.text = desc
                release.text = "Release Date: $releaseDate"
                backButton.setOnClickListener {
                    finish()
                }
            }
            val imagePath = "https://image.tmdb.org/t/p/w500/" + picPath
            Glide.with(binding.imageView.context).load(imagePath).into(binding.imageView)
    }

}