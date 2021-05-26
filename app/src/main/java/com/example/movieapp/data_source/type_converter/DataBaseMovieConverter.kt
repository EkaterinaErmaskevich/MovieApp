package com.example.movieapp.data_source.type_converter

import androidx.room.TypeConverter
import com.example.movieapp.data_source.entity.GenreEntity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class DataBaseMovieConverter {

    ///// THERE ARE MISTAKE !!!!
    @TypeConverter
    fun genresToJson(list: List<GenreEntity>?): String {
        return Gson().toJson(list, object : TypeToken<List<GenreEntity>>() {}.type)
    }

    @TypeConverter
    fun jsonToGenres(json: String): List<GenreEntity> {
        return Gson().fromJson(json, object : TypeToken<List<GenreEntity>>() {}.type)
    }
}


