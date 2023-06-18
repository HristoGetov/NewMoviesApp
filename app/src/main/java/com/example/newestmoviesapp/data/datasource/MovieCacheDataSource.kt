package com.example.newestmoviesapp.data.datasource

import com.example.newestmoviesapp.data.model.Movie

interface MovieCacheDataSource {
    suspend fun getMoviesFromCache():List<Movie>
    suspend fun saveMoviesToCache(movies: List<Movie>)
}