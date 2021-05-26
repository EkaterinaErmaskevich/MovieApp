package com.example.movieapp.di.modules

import com.example.movieapp.data_source.DataSource
import com.example.movieapp.di.scopes.RepositoryScope
import com.example.movieapp.remote_data_source.RemoteDataSource
import com.example.movieapp.repository.MovieRepository
import com.example.movieapp.repository.MovieRepositoryImpl
import dagger.Module
import dagger.Provides


@Module
class RepositoryModule {

    @RepositoryScope
    @Provides
    internal fun providesFeedRepository(
        dataSource: DataSource,
        remoteDataSource: RemoteDataSource
    ): MovieRepository {
        return MovieRepositoryImpl(dataSource, remoteDataSource)
    }
}