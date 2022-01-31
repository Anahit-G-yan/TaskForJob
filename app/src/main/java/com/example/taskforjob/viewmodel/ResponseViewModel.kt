package com.example.taskforjob.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.taskforjob.model.ResponseModel
import com.example.taskforjob.network.service.RetrofitClient
import kotlinx.coroutines.launch

class ResponseViewModel(application: Application) : AndroidViewModel(application) {
    //Live data of response
    val newsLiveData = MutableLiveData<ResponseModel?>()

    //send a request to the service and get response
    private suspend fun getNews(): ResponseModel? {
        try {
            val response = RetrofitClient().createService().getNews()
            if (response.isSuccessful && response.body() != null) {
                return response.body()
            }
            //for getting Toast
        }catch (e: Throwable){
            return null
    }
        return null
    }

    //send the received response
    fun getAllNews(){
        viewModelScope.launch {
            newsLiveData.postValue(getNews())
        }
    }
}