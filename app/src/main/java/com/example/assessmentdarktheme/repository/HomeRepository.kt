package com.example.assessmentdarktheme.repository

import android.util.Log
import com.example.assessmentdarktheme.application.MyApplication
import com.example.assessmentdarktheme.data.model.NewsCallBack
import com.example.assessmentdarktheme.data.retrofit.RetrofitServiceInterface
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class HomeRepository @Inject constructor(){
    private val job = Job()
    private val scope = CoroutineScope(Dispatchers.IO + job)
    @Inject
    lateinit var apiService: RetrofitServiceInterface
    init {
        MyApplication.instance?.getRetrofitComponent()?.inject(this)
    }

    fun getNews(onResult: (isSuccess:Boolean, throwable:Throwable?, response:NewsCallBack?) -> Unit){
        scope.launch {
            apiService.getNews().enqueue(
                object : Callback<NewsCallBack> {
                    override fun onResponse(
                        call: Call<NewsCallBack>,
                        response: Response<NewsCallBack>
                    ) {
                        onResult(true, null,response.body()!!)
                    }

                    override fun onFailure(call: Call<NewsCallBack>, t: Throwable) {
                        onResult(false, t,null)
                    }

                }
            )
        }

    }

}