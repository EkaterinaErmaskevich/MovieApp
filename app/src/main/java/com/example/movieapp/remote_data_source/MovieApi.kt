package com.example.movieapp.remote_data_source

import com.example.movieapp.remote_data_source.pojo.MovieResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {
    companion object{
        const val API_KEY="3343ea649bac29142b588728c4b35103"
    }

    //Movies
@GET("movie/popular")
fun getPopularMovieList(
        @Query("api_key") apiKey: String = API_KEY
    ): Single<MovieResponse>




    //Actors
}