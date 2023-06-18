package com.example.newestmoviesapp.data.model

import com.google.gson.annotations.SerializedName

data class MoviesList(

    @SerializedName("results")
    val allMovies: List<Movie>
)
