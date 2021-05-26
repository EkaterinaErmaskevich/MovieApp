package com.example.movieapp.data_source

import com.example.movieapp.data_source.entity.MovieEntity
import io.reactivex.Completable
import io.reactivex.Single

interface DataSource {
    fun deleteMovie(): Completable
    fun showPopularMovie(): Single<List<MovieEntity>>
    fun insertListMovie(movieList: List<MovieEntity>): Completable
//    fun showMovieInfo(id:Int): Single<MovieEntity>
//    fun insertMovieInfo (movie:MovieEntity):Completable


    fun insertAndClearList(movieList: List<MovieEntity>): Completable
    //   fun insertAndClearMovieInfo(movie: MovieEntity):Completable

}

class DataSourceImpl(private val movieRoomDataBase: MovieRoomDataBase) : DataSource {

    override fun deleteMovie(): Completable = Completable.fromAction {
        movieRoomDataBase.movieDao().deleteMovie()
    }

    override fun showPopularMovie(): Single<List<MovieEntity>> =
        movieRoomDataBase.movieDao().showPopularListMovies()

    override fun insertListMovie(movieList: List<MovieEntity>): Completable =
        Completable.fromAction {

            movieRoomDataBase.movieDao().insertListMovies(movieList)
        }

    override fun insertAndClearList(movieList: List<MovieEntity>): Completable =
        Completable.fromAction {
            movieRoomDataBase.movieDao().insertAndClearListMovies(movieList)
        }

}