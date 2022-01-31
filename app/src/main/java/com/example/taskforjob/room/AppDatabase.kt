package com.example.taskforjob.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.taskforjob.room.dao.NewsDao
import com.example.taskforjob.room.entity.NewsEntity

@Database(entities = [NewsEntity::class], version = 1)

//Create RoomDatabase for favorite news
abstract class AppDatabase: RoomDatabase() {

    abstract fun newsDao(): NewsDao

    companion object {
        private var mInstance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            if (mInstance != null) {
                return mInstance!!;
            }
            synchronized(this) {
                mInstance = Room.databaseBuilder(
                    context, AppDatabase::class.java,
                    "testRoomDbName"
                ).build()
            }
            return mInstance!!
        }
    }
}