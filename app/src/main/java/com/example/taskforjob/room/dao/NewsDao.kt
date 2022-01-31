package com.example.taskforjob.room.dao

import androidx.room.*
import com.example.taskforjob.room.entity.NewsEntity

@Dao
interface NewsDao {

    //to save the news to favorites
    @Insert
    fun insert(taskEntity: NewsEntity)

    //foe getting all favorite news
    @Query("select * from news")
    fun getAll(): List<NewsEntity>

}