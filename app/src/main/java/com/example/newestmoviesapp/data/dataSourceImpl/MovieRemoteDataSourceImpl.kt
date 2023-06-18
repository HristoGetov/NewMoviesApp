package com.example.newestmoviesapp.data.dataSourceImpl

import com.example.newestmoviesapp.data.api.MoviesService
import com.example.newestmoviesapp.data.datasource.MovieRemoteDataSource
import com.example.newestmoviesapp.data.model.MoviesList
import retrofit2.Response

class MovieRemoteDataSourceImpl(
    private val movieService: MoviesService,
    private val apiKey: String):
    MovieRemoteDataSource {

    override suspend fun getMovies(): Response<MoviesList> =
        movieService.getPopularMovies(apiKey)
}