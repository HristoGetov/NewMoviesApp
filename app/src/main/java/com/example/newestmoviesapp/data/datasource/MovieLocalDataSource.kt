package com.example.newestmoviesapp.data.datasource

import com.example.newestmoviesapp.data.model.Movie
import com.example.newestmoviesapp.data.model.MoviesList

interface MovieLocalDataSource {

    suspend fun getMoviesFromDB(): List<Movie>
    suspend fun saveMoviesToDB(movies: List<Movie>)
    suspend fun clearAll()
}