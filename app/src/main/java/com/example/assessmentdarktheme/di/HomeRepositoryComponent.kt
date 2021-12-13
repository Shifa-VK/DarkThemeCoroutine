package com.example.assessmentdarktheme.di

import com.example.assessmentdarktheme.ui.home.HomeViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [HomeRepositoryModule::class])
interface HomeRepositoryComponent {
    fun inject(homeViewModel: HomeViewModel)
}