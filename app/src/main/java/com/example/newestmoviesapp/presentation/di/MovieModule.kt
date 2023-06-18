package com.example.newestmoviesapp.presentation.di

import com.example.newestmoviesapp.domain.usecases.GetMoviesUseCase
import com.example.newestmoviesapp.domain.usecases.UpdateMoviesUseCase
import com.example.newestmoviesapp.presentation.ViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MovieModule {
    @MovieScope
    @Provides
    fun provideMovieViewModelFactory(
        getMoviesUseCase: GetMoviesUseCase,
        updateMovieUseCase: UpdateMoviesUseCase
    ): ViewModelFactory {
        return ViewModelFactory(getMoviesUseCase, updateMovieUseCase)
    }
}