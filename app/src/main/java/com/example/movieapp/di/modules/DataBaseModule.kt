package com.example.movieapp.di.modules


import com.example.movieapp.data_source.DataSourceImpl
import com.example.movieapp.data_source.MovieRoomDataBase
import com.example.movieapp.data_source.DataSource
import dagger.Module
import dagger.Provides


@Module
class DataBaseModule(private val movieDataBase: MovieRoomDataBase) {

    @Provides
    internal fun providesAppDataBase(): MovieRoomDataBase {
        return movieDataBase
    }

    @Provides
    internal fun providesFeedDataSource(movieDataBase: MovieRoomDataBase): DataSource {
        return DataSourceImpl(movieDataBase)
    }
}