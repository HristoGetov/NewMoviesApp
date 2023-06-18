package com.example.newestmoviesapp.data.model

import androidx.room.Entity
import com.google.gson.annotations.SerializedName

@Entity(tableName = "movies")
data class Movie(


    val id: Int,
    @SerializedName("original_language")
    val originalLanguage: String,

    val overview: String,

    @SerializedName("poster_path")
    val posterPath: String,

    @SerializedName("release_date")
    val releaseDate: String,

    val title:String,

    @SerializedName("vote_average")
    val voteAverage: Double,

    @SerializedName("vote_count")
    val voteCount: Int
)
