package com.example.newestmoviesapp.data.datasource

import com.example.newestmoviesapp.data.model.MoviesList
import retrofit2.Response

interface MovieRemoteDataSource {
    suspend fun getMovies(): Response<MoviesList>
}