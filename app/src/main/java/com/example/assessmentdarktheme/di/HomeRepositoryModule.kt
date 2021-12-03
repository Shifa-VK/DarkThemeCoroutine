package com.example.assessmentdarktheme.di

import com.example.assessmentdarktheme.repository.HomeRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class HomeRepositoryModule {
    @Provides
    @Singleton
    fun getHomeRepository(): HomeRepository = HomeRepository()
}