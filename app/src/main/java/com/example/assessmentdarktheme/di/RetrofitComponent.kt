package com.example.assessmentdarktheme.di

import com.example.assessmentdarktheme.repository.HomeRepository
import com.example.assessmentdarktheme.ui.HomeViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [RetrofitModule::class])
interface RetrofitComponent {
    fun inject(homeRepository:HomeRepository)
}