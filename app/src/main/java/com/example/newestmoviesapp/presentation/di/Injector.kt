package com.example.newestmoviesapp.presentation.di

interface Injector {
    fun createMovieSubComponent(): MovieSubComponent
}