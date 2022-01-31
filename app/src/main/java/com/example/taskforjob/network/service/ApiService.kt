package com.example.taskforjob.network.service

import com.example.taskforjob.model.ResponseModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("search?api-key=47e3d9d1-deaa-48e4-91b5-22626d989258")
    suspend fun getNews(): Response<ResponseModel>
}
