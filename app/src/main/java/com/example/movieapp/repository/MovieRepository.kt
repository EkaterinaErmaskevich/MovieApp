package com.example.movieapp.repository

import com.example.movieapp.data_source.DataSource
import com.example.movieapp.data_source.entity.MovieEntity
import com.example.movieapp.remote_data_source.RemoteDataSource
import io.reactivex.Completable
import io.reactivex.CompletableSource
import io.reactivex.Single

interface MovieRepository {

    fun getPopularMovie(): Completable
    fun deleteMovie(): Completable
    fun showPopularMovie(): Single<List<MovieEntity>>

}

class MovieRepositoryImpl(

    private val dataSource: DataSource,
    private val remoteDataSource: RemoteDataSource

) : MovieRepository {

    override fun deleteMovie(): Completable {
        return dataSource.deleteMovie()
    }

    override fun getPopularMovie(): Completable {
        return remoteDataSource.getPopularMovie()
            .flatMapCompletable { list -> saveListMovie(itemsMovie = list, isCached = true) }
    }


    override fun showPopularMovie(): Single<List<MovieEntity>> {
        return dataSource.showPopularMovie()

    }

    private fun saveListMovie(
        itemsMovie: List<MovieEntity>,
        isCached: Boolean
    ): CompletableSource? {
        return if (isCached) {
            dataSource.insertListMovie(itemsMovie)
        } else {
            dataSource.insertAndClearList(itemsMovie)
        }
    }
}
