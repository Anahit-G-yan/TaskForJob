package com.example.taskforjob.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.taskforjob.model.ResponseModel
import com.example.taskforjob.room.AppDatabase
import com.example.taskforjob.room.entity.NewsEntity

class FavoriteViewModel(application: Application) : AndroidViewModel(application) {

    //Live data of favorite news
    val favoriteNewsLiveData = MutableLiveData<List<NewsEntity>>()
    val toastLiveData = MutableLiveData<Boolean>()


    //getting all favorite news from DB
    fun getAll() {
        Thread {
            favoriteNewsLiveData.postValue(
                AppDatabase
                    .getInstance(getApplication())
                    .newsDao()
                    .getAll()
            )
        }.start()
    }

    //saving news to favorite
    fun insert(newsItem: ResponseModel.Response.Result) {
        Thread {
            try {
                val entity = NewsEntity(
                    newsItem.apiUrl,
                    newsItem.id,
                    newsItem.isHosted,
                    newsItem.pillarId,
                    newsItem.pillarName,
                    newsItem.sectionId,
                    newsItem.sectionName,
                    newsItem.type,
                    newsItem.webPublicationDate,
                    newsItem.webTitle,
                    newsItem.webUrl
                )
                AppDatabase
                    .getInstance(getApplication())
                    .newsDao()
                    .insert(entity)
            } catch (e: Throwable) {
                //if we have duplicates in DB, we get Toast
                toastLiveData.postValue(true)
            }

        }.start()
    }
}