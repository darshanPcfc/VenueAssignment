package com.example.abnambrotest.di

import com.example.abnambrotest.ni.retrofit.MainApiInterface
import com.example.abnambrotest.ni.retrofit.createNetworkClient
import org.koin.dsl.module
import retrofit2.Retrofit

/**
 * Created by Darshan Patel 24/02/2020
 * Usage:
 * How to call:
 * Useful parameter:
 */
private val retrofit: Retrofit = createNetworkClient()
private val MAIN_API_INTERCEPTOR: MainApiInterface = retrofit.create(MainApiInterface::class.java)
val apiInjections = module {
    single { MAIN_API_INTERCEPTOR }
}