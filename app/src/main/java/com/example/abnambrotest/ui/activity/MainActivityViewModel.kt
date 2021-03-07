package com.example.abnambrotest.ui.activity

import android.app.Application
import com.example.abnambrotest.base.BaseViewModel
import com.example.abnambrotest.networkinterface.repository.MainApiRepository
import com.example.abnambrotest.networkinterface.retrofit.MainApiInterface

/**
 * Created by Darshan Patel
 * Usage: ViewModel for MainActivity
 * Useful parameter: appcontext and api interface instance extend your base viewmodel and pass your navigator
 */
class MainActivityViewModel(application: Application, mainApiInterface: MainApiInterface) :
    BaseViewModel<IMainActivityNavigator>() {

    private val mainApiRepository: MainApiRepository =
        MainApiRepository(application, mainApiInterface)
}