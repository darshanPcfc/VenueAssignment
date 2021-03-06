package com.example.abnambrotest.ui.activity

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.abnambrotest.base.BaseViewModel
import com.example.abnambrotest.ni.remote.response.search.SearchVenueResponse
import com.example.abnambrotest.ni.repository.MainApiRepository
import com.example.abnambrotest.ni.retrofit.MainApiInterface

class MainActivityViewModel(application: Application, val mainApiInterface: MainApiInterface) :
    BaseViewModel<IMainActivityNavigator>()  {

    private val mainApiRepository: MainApiRepository =
        MainApiRepository(application, mainApiInterface)

}