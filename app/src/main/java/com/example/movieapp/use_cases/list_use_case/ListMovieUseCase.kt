package com.example.movieapp.use_cases.list_use_case

import com.example.movieapp.data_source.entity.MovieEntity
import com.example.movieapp.repository.MovieRepository
import io.reactivex.Completable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


interface ListMovieUseCase {

    fun getPopularMovie(): Completable
    fun deleteMovie(): Completable
    fun showPopularMovie(): Single<List<MovieEntity>>

}

class ListMovieUseCaseImpl(

    private val repository: MovieRepository


) : ListMovieUseCase {

    override fun deleteMovie(): Completable = repository.deleteMovie()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())


    override fun getPopularMovie(): Completable = repository.getPopularMovie()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())


    override fun showPopularMovie(): Single<List<MovieEntity>> = repository.showPopularMovie()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())


}





