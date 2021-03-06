package com.example.abnambrotest.di

import com.example.abnambrotest.ui.activity.MainActivityViewModel
import com.example.abnambrotest.ui.fragment.detailfragment.DetailViewModel
import com.example.abnambrotest.ui.fragment.searchfragment.SearchViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by Darshan Patel 24/02/2020
 * Usage:
 * How to call:
 * Useful parameter:
 */
val viewModelsInjection = module {
    viewModel { MainActivityViewModel(androidApplication(), get()) }
    viewModel { SearchViewModel(androidApplication(), get()) }
    viewModel { DetailViewModel(androidApplication(), get()) }
}