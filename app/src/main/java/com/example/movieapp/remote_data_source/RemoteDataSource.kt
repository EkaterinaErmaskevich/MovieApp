package com.example.movieapp.remote_data_source

import com.example.movieapp.data_source.entity.MovieEntity
import io.reactivex.Single

interface RemoteDataSource {

    fun getPopularMovie(): Single <List<MovieEntity>>

}

class RemoteDataSourceImpl(private val movieApi: MovieApi):RemoteDataSource{
    override fun getPopularMovie(): Single<List<MovieEntity>> {
        return movieApi.getPopularMovieList().map {
            it.result
        }
    }
}