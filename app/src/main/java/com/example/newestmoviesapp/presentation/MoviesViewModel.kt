package com.example.newestmoviesapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.newestmoviesapp.domain.usecases.GetMoviesUseCase
import com.example.newestmoviesapp.domain.usecases.UpdateMoviesUseCase

class MoviesViewModel(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val updateMovieUseCase: UpdateMoviesUseCase
): ViewModel()    {

        fun getMovies() = liveData {
            val movieList = getMoviesUseCase.execute()
            emit(movieList)
        }
        fun updateMovies() = liveData {
            val movieList = updateMovieUseCase.execute()
            emit(movieList)
        }
}