package com.example.newestmoviesapp.presentation.di

import com.example.newestmoviesapp.presentation.MainActivity
import dagger.Subcomponent

@MovieScope
@Subcomponent(modules = [MovieModule::class])
interface MovieSubComponent {
    fun inject(movieActivity: MainActivity)

    @Subcomponent.Factory
    interface  Factory{
        fun create():MovieSubComponent
    }

}