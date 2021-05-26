package com.example.movieapp.di.modules

import android.app.Application
import com.example.movieapp.MovieApp
import com.example.movieapp.di.scopes.ViewModelScope
import com.example.movieapp.use_cases.list_use_case.ListMovieUseCase
import com.example.movieapp.view_model.ListMovieViewModel
import dagger.Module
import dagger.Provides


@Module

class ViewModelModule(private val app: MovieApp) {

    var mApp: Application = this.app

    @ViewModelScope
    @Provides
    internal fun providesFeedViewModel(listMovieUseCase: ListMovieUseCase): ListMovieViewModel {
        return ListMovieViewModel(listMovieUseCase)

    }
}