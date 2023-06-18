package com.example.newestmoviesapp.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.newestmoviesapp.data.model.Movie

@Database(entities = [Movie::class], version = 1, exportSchema = false)
abstract class MoviesDatabase :RoomDatabase() {

    abstract fun movieDao() : MovieDao
}