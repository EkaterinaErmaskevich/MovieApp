package com.example.movieapp.di.components

import com.example.movieapp.di.modules.ViewModelModule
import com.example.movieapp.di.scopes.ViewModelScope
import com.example.movieapp.presentation.activities.MainActivity
import com.example.movieapp.presentation.fragments.MovieListFragment
import dagger.Component


@ViewModelScope
@Component(modules = [ViewModelModule::class],dependencies = [UseCaseComponent::class])
interface ViewModelComponent {
    fun inject (activity : MainActivity)
    fun inject (fragment: MovieListFragment)
}
