package com.example.movieapp.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.movieapp.data_source.dao.MovieDao
import com.example.movieapp.data_source.entity.MovieEntity
import com.example.movieapp.data_source.type_converter.DataBaseMovieConverter


@Database(entities = [MovieEntity::class], version = 1)
@TypeConverters(DataBaseMovieConverter::class)

abstract class MovieRoomDataBase : RoomDatabase() {
    abstract fun movieDao(): MovieDao

}