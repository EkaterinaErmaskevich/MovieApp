package com.example.movieapp.data_source.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "movie")
data class MovieEntity(

    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val overview: String,
    @SerializedName("poster_path")
    val posterPath: String,
    val title: String,
    @SerializedName("vote_average")
    val rating: Double,
    @SerializedName("genres")
    val genre: List<GenreEntity>?

)