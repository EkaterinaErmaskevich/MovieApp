package com.example.movieapp.remote_data_source.pojo

import com.example.movieapp.data_source.entity.MovieEntity
import com.google.gson.annotations.SerializedName

data class MovieResponse(

    @SerializedName("page")
    val page: Int,
    @SerializedName("result")
    val result: List<MovieEntity>

)