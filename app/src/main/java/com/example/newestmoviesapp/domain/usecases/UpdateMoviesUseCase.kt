package com.example.newestmoviesapp.domain.usecases

import com.example.newestmoviesapp.data.model.Movie
import com.example.newestmoviesapp.domain.repository.MovieRepository

class UpdateMoviesUseCase(private val movieRepository: MovieRepository) {
    suspend fun execute(): List<Movie>? = movieRepository.updateMovies()
}