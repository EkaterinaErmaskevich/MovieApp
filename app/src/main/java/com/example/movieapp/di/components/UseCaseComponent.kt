package com.example.movieapp.di.components

import com.example.movieapp.di.modules.UseCaseModule
import com.example.movieapp.di.scopes.UseCaseScope
import com.example.movieapp.use_cases.list_use_case.ListMovieUseCase
import dagger.Component

@UseCaseScope
@Component(modules = [UseCaseModule::class],dependencies = [RepositoryComponent::class])
interface UseCaseComponent {
    val listMovieUseCase:ListMovieUseCase
}