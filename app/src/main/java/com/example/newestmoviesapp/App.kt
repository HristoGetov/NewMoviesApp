package com.example.newestmoviesapp

import android.app.Application

import com.example.newestmoviesapp.presentation.di.AppComponent
import com.example.newestmoviesapp.presentation.di.AppModule
import com.example.newestmoviesapp.presentation.di.DaggerAppComponent
import com.example.newestmoviesapp.presentation.di.Injector
import com.example.newestmoviesapp.presentation.di.MovieSubComponent
import com.example.newestmoviesapp.presentation.di.RemoteDataModule
import com.example.newestmoviesapp.presentation.di.RemoteModule

class App: Application(), Injector {

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .remoteModule(RemoteModule(BuildConfig.BASE_URL))
            .remoteDataModule(RemoteDataModule(BuildConfig.API_KEY))
            .build()
    }

    override fun createMovieSubComponent(): MovieSubComponent {
        return appComponent.movieSubcomponent().create()
    }
}