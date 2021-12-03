package com.example.assessmentdarktheme.di

import com.example.assessmentdarktheme.data.retrofit.RetrofitServiceInterface
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class RetrofitModule {
    val baseUrl = "http://newsapi.org"

    @Singleton
    @Provides
    fun getRetrofitServiceInstance(retrofit: Retrofit):RetrofitServiceInterface{
        return retrofit.create(RetrofitServiceInterface::class.java)
    }

    @Singleton
    @Provides
    fun getRetrofitInstance():Retrofit{
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl)
            .build()
    }

}