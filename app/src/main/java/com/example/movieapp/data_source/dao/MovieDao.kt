package com.example.movieapp.data_source.dao

import androidx.room.*
import com.example.movieapp.data_source.entity.MovieEntity
import io.reactivex.Single

@Dao
interface MovieDao {

    @Query("DELETE FROM movie")
    fun deleteMovie()

    @Query("SELECT*FROM movie")
    fun showPopularListMovies(): Single<List<MovieEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertListMovies(movieList: List<MovieEntity>)

    @Transaction
    fun insertAndClearListMovies(movieList: List<MovieEntity>) {
        deleteMovie()
        insertListMovies(movieList)
    }

}