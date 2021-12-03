package com.example.assessmentdarktheme.ui
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.assessmentdarktheme.application.MyApplication
import com.example.assessmentdarktheme.data.model.NewsCallBack
import com.example.assessmentdarktheme.repository.HomeRepository
import javax.inject.Inject

class HomeViewModel () : ViewModel() {
    @Inject
    lateinit var homeRepository: HomeRepository
    val newsCallBack = MutableLiveData<NewsCallBack>()
    val newsthrowable = MutableLiveData<Throwable>()
    init {
        MyApplication.getInstance().getHomeRepositoryComponent().inject(this)
    }
    fun getNews(){
        homeRepository.getNews(){ isSuccess, throwable, response ->
            if(isSuccess && response != null){
                newsCallBack.postValue(response)
            }
            else if(throwable != null){
                newsthrowable.postValue(throwable)
            }
        }
    }
}