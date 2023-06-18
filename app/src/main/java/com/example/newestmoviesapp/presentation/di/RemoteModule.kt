package com.example.newestmoviesapp.presentation.di

import com.example.newestmoviesapp.data.api.MoviesService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

//Used to provide a Retrofit instance
@Module
class RemoteModule(private val base_url: String) {

    @Singleton
    @Provides
    fun providesRetrofit():Retrofit{
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(base_url)
            .build()
    }

    @Singleton
    @Provides
    fun providesTMDBService(retrofit: Retrofit): MoviesService{
        return retrofit.create(MoviesService ::class.java)
    }

}