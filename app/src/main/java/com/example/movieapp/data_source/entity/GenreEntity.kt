package com.example.movieapp.data_source.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "genres")

data class GenreEntity(

    @PrimaryKey(autoGenerate = false)
    val id: Int,
    @SerializedName("name")
    val name: String

)