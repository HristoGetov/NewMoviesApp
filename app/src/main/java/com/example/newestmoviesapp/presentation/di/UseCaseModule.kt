package com.example.newestmoviesapp.presentation.di

import com.example.newestmoviesapp.domain.repository.MovieRepository
import com.example.newestmoviesapp.domain.usecases.GetMoviesUseCase
import com.example.newestmoviesapp.domain.usecases.UpdateMoviesUseCase
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    @Provides
    fun provideGetMovieUseCase(movieRepository: MovieRepository): GetMoviesUseCase {
        return GetMoviesUseCase(movieRepository)
    }

    @Provides
    fun provideUpdateMovieUseCase(movieRepository: MovieRepository): UpdateMoviesUseCase {
        return UpdateMoviesUseCase(movieRepository)
    }
}