package com.example.movieapp.view_model

import androidx.lifecycle.MutableLiveData
import com.example.movieapp.data_source.entity.MovieEntity
import com.example.movieapp.use_cases.list_use_case.ListMovieUseCase
import io.reactivex.rxkotlin.plusAssign

class ListMovieViewModel(
    val listMovieUseCase: ListMovieUseCase
) : BaseViewModel() {

    val listPopularMovie = MutableLiveData<List<MovieEntity>>()

    fun getPopularMovieList() {
        compositeDisposable += listMovieUseCase.getPopularMovie()
            .subscribe({
                showPopMovie()
            }, {
                it.printStackTrace()
            })
    }

    private fun showPopMovie() {
        compositeDisposable += listMovieUseCase.showPopularMovie()
            .subscribe({
                popMovie->
                listPopularMovie.value = popMovie
            },{
                it.printStackTrace()
            })

    }

}


