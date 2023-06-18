package com.example.newestmoviesapp.data.dataSourceImpl


import com.example.newestmoviesapp.data.datasource.MovieCacheDataSource
import com.example.newestmoviesapp.data.model.Movie

class MovieCacheDataSourceImpl: MovieCacheDataSource {

    private var movieList = ArrayList<Movie>()

    override suspend fun getMoviesFromCache(): List<Movie> {
        return movieList
    }

    override suspend fun saveMoviesToCache(movies: List<Movie>) {
        movieList.clear()
        movieList = ArrayList(movies)
    }
}