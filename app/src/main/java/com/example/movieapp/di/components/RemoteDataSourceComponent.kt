package com.example.movieapp.di.components

import com.example.movieapp.di.modules.RemoteDataSourceModule
import com.example.movieapp.di.scopes.RemoteDataSourceScope
import com.example.movieapp.remote_data_source.RemoteDataSource
import dagger.Component

@RemoteDataSourceScope
@Component(modules = [RemoteDataSourceModule::class])
interface RemoteDataSourceComponent {
    val remoteDataSource: RemoteDataSource
}