package com.example.newestmoviesapp.data.db

import androidx.room.Database
import com.example.newestmoviesapp.data.model.Movie

@Database(entities = [Movie::class], version = 1, exportSchema = false)
abstract class MoviesDatabase {

    abstract fun movieDao() : MovieDao
}