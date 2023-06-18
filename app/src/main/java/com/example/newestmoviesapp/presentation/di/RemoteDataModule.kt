package com.example.newestmoviesapp.presentation.di


import com.example.newestmoviesapp.data.api.MoviesService
import com.example.newestmoviesapp.data.dataSourceImpl.MovieRemoteDataSourceImpl
import com.example.newestmoviesapp.data.datasource.MovieRemoteDataSource
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

//Used to provide a MovieRemoteDataSource instance
@Module
class RemoteDataModule(private val apiKey: String) {

    @Singleton
    @Provides
    fun providesModuleRemoteDataSource(moviesService: MoviesService):MovieRemoteDataSource{
        return MovieRemoteDataSourceImpl(
            moviesService,
            apiKey
        )
    }
}