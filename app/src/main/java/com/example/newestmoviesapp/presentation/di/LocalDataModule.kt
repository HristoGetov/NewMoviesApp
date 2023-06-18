package com.example.newestmoviesapp.presentation.di


import com.example.newestmoviesapp.data.dataSourceImpl.MovieLocalDataSourceImpl
import com.example.newestmoviesapp.data.datasource.MovieLocalDataSource
import com.example.newestmoviesapp.data.db.MovieDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule() {

    @Singleton
    @Provides
    fun provideMovieLocalDataSource(movieDAO: MovieDao): MovieLocalDataSource {
        return MovieLocalDataSourceImpl(movieDAO)
    }
}