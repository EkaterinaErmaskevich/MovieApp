package com.example.movieapp.di.components

import com.example.movieapp.di.modules.RepositoryModule
import com.example.movieapp.di.scopes.RepositoryScope
import com.example.movieapp.repository.MovieRepository
import dagger.Component

@RepositoryScope
@Component (modules = [RepositoryModule::class], dependencies = [DataSourceComponent::class, RemoteDataSourceComponent::class])
interface RepositoryComponent {
    val movieRepository: MovieRepository
}