package com.example.movieapp.di.modules

import com.example.movieapp.di.scopes.UseCaseScope
import com.example.movieapp.repository.MovieRepository
import com.example.movieapp.use_cases.list_use_case.ListMovieUseCaseImpl
import dagger.Module
import dagger.Provides
import com.example.movieapp.use_cases.list_use_case.ListMovieUseCase as ListMovieUseCase


@Module
class UseCaseModule {

    @UseCaseScope
    @Provides
    internal fun providesRepositoriesUseCase(repository: MovieRepository): ListMovieUseCase {
        return ListMovieUseCaseImpl(repository)
    }


}