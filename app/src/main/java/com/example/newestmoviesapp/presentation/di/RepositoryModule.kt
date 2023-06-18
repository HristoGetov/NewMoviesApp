package com.example.newestmoviesapp.presentation.di

import com.example.newestmoviesapp.data.MovieRepositoryImpl
import com.example.newestmoviesapp.data.datasource.MovieCacheDataSource
import com.example.newestmoviesapp.data.datasource.MovieLocalDataSource
import com.example.newestmoviesapp.data.datasource.MovieRemoteDataSource
import com.example.newestmoviesapp.domain.repository.MovieRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideMovieRepository(movieRemoteDatasource: MovieRemoteDataSource,
                               movieLocalDataSource: MovieLocalDataSource,
                               movieCacheDataSource: MovieCacheDataSource
    ): MovieRepository {
        return MovieRepositoryImpl(
            movieRemoteDatasource,
            movieLocalDataSource,
            movieCacheDataSource
        )
    }
}