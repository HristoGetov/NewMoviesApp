package com.example.newestmoviesapp.data

import android.util.Log
import com.example.newestmoviesapp.data.datasource.MovieCacheDataSource
import com.example.newestmoviesapp.data.datasource.MovieLocalDataSource
import com.example.newestmoviesapp.data.datasource.MovieRemoteDataSource
import com.example.newestmoviesapp.data.model.Movie
import com.example.newestmoviesapp.domain.repository.MovieRepository


class MovieRepositoryImpl(
    private val movieRemoteDatasource: MovieRemoteDataSource,
    private val movieLocalDataSource: MovieLocalDataSource,
    private val movieCacheDataSource: MovieCacheDataSource
): MovieRepository {


    override suspend fun getMovies(): List<Movie>? {
        return getMoviesFromCache()
    }



    override suspend fun updateMovies(): List<Movie>? {
        val newListOfMovies = getMoviesFromAPI()
        movieLocalDataSource.clearAll()
        movieLocalDataSource.saveMoviesToDB(newListOfMovies)
        movieCacheDataSource.saveMoviesToCache(newListOfMovies)
        return newListOfMovies
    }

    private suspend fun getMoviesFromCache(): List<Movie>? {
        lateinit var movieList: List<Movie>

        try {
            movieList = movieCacheDataSource.getMoviesFromCache()
        }catch (exception: Exception){
            Log.e("Error", exception.toString())
        }
        if(movieList.isNotEmpty()){
            return movieList
        }else{
            movieList = getMoviesFromROOM()
            movieCacheDataSource.saveMoviesToCache(movieList)
        }
        return movieList
    }

    private suspend fun getMoviesFromROOM(): List<Movie>{
        lateinit var movieList: List<Movie>
        try {
            movieList = movieLocalDataSource.getMoviesFromDB()
        }catch (ex: java.lang.Exception){
            Log.e("Error", ex.toString())
        }
        if (movieList.isNotEmpty()){
            return movieList
        }else{
            movieList = getMoviesFromAPI()
            movieLocalDataSource.saveMoviesToDB(movieList)
        }
        return movieList
    }


    private suspend fun getMoviesFromAPI(): List<Movie> {
        lateinit var moviesList: List<Movie>
        try {
            val response = movieRemoteDatasource.getMovies()
            val body = response.body()
            if (body != null){
                moviesList = body.allMovies
            }
        }catch (ex:Exception){
            Log.e("Error", ex.toString())
        }
        return moviesList
    }
}