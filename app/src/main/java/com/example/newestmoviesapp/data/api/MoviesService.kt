package com.example.newestmoviesapp.data.api

import com.example.newestmoviesapp.data.MoviesList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesService {

    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("api_key") apiKey: String
    ):Response<MoviesList>
}