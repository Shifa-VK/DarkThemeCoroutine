package com.example.assessmentdarktheme.application

import android.app.Application
import com.example.assessmentdarktheme.di.*

class MyApplication:Application() {
    private lateinit var retrofitComponent: RetrofitComponent
    private lateinit var homeRepositoryComponent: HomeRepositoryComponent

    override fun onCreate() {
        super.onCreate()
        retrofitComponent                   = DaggerRetrofitComponent.builder()
                                                .retrofitModule(RetrofitModule())
                                                .build()

        homeRepositoryComponent             = DaggerHomeRepositoryComponent.builder()
                                                .homeRepositoryModule(HomeRepositoryModule())
                                                .build()
    }

    fun getRetrofitComponent():RetrofitComponent{
        return retrofitComponent
    }

    fun getHomeRepositoryComponent():HomeRepositoryComponent{
        return homeRepositoryComponent
    }

    companion object{
        var instance : MyApplication ?= null

        @JvmName("getInstance1")
        @Synchronized
        fun getInstance():MyApplication{
            return instance!!
        }
    }

    init {
        instance = this
    }
}