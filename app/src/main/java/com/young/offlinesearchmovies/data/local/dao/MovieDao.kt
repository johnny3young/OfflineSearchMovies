package com.young.offlinesearchmovies.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.young.offlinesearchmovies.data.local.entity.MovieEntity

interface MovieDao {

    @Query("SELECT * FROM movies")
     fun loadMovies(): LiveData<List<MovieEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
     fun saveMovies(movieEntityList: List<MovieEntity>)
}