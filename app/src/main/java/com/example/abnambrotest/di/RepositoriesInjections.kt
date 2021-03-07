package com.example.abnambrotest.di

import com.example.abnambrotest.networkinterface.repository.MainApiRepository
import com.example.abnambrotest.networkinterface.repository.VenueDetailRepository
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

/**
 * Created by Darshan Patel
 * Usage: include all your Repositories for KOIN
 * How to call: initialise through Koin
 * Useful parameter: context and api interface instance
 */

val repositoriesInjection = module {
    single { MainApiRepository(androidContext(), mainApiInterceptor = get()) }
    single { VenueDetailRepository(androidContext(), mainApiInterceptor = get()) }
}