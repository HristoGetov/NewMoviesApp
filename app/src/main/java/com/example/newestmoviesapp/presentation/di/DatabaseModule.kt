package com.example.newestmoviesapp.presentation.di

import android.content.Context
import androidx.room.Room
import com.example.newestmoviesapp.data.db.MovieDao
import com.example.newestmoviesapp.data.db.MoviesDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

//Used to provide a Room database instance
@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideMovieDatabase(context:Context):MoviesDatabase{
        return Room.databaseBuilder(context,
        MoviesDatabase::class.java,
        "tmdbclient").build()
    }

    @Singleton
    @Provides
    fun providesMoviesDAO(tmdbDatabase: MoviesDatabase): MovieDao{
        return tmdbDatabase.movieDao()
    }
}