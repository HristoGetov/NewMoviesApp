package com.example.newestmoviesapp.presentation.di


import com.example.newestmoviesapp.data.dataSourceImpl.MovieCacheDataSourceImpl
import com.example.newestmoviesapp.data.datasource.MovieCacheDataSource
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {

    @Singleton
    @Provides
    fun provideMovieCacheDataSource(): MovieCacheDataSource {
        return MovieCacheDataSourceImpl()
    }
}