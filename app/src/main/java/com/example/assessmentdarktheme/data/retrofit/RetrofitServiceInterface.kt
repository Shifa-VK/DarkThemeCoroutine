package com.example.assessmentdarktheme.data.retrofit

import com.example.assessmentdarktheme.data.model.NewsCallBack
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitServiceInterface {

    @GET("/v2/top-headlines?country=in&category=sports&apiKey=17ca53c2d12e446b9bdff6efb93e7555")
    fun getNews(): Call<NewsCallBack>
}