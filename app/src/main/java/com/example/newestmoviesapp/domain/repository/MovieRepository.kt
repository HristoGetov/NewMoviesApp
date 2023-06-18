package com.example.newestmoviesapp.domain.repository

import com.example.newestmoviesapp.data.model.Movie

interface MovieRepository {
    suspend fun getMovies(): List<Movie>?
    suspend fun updateMovies(): List<Movie>?
}