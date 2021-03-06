package com.example.abnambrotest.di

import com.example.abnambrotest.ni.repository.MainApiRepository
import com.example.abnambrotest.ni.repository.VenueDetailRepository
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

/**
 * Created by Darshan Patel
 * Usage:
 * How to call:
 * Useful parameter:
 */

val repositoriesInjection = module {
    single { MainApiRepository(androidContext(), mainApiInterceptor = get()) }
    single { VenueDetailRepository(androidContext(), mainApiInterceptor = get()) }
}