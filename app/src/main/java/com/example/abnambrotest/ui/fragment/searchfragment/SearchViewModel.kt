package com.example.abnambrotest.ui.fragment.searchfragment

import android.app.Application
import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import com.example.abnambrotest.base.BaseApplication
import com.example.abnambrotest.base.BaseViewModel
import com.example.abnambrotest.db.VenueViewModel
import com.example.abnambrotest.ni.remote.response.search.SearchVenueResponse
import com.example.abnambrotest.ni.remote.response.search.Venues
import com.example.abnambrotest.ni.repository.MainApiRepository
import com.example.abnambrotest.ni.retrofit.MainApiInterface
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class SearchViewModel(application: Application, val mainApiInterface: MainApiInterface) :
    BaseViewModel<ISearchNavigator>() {

    val searchText  = ObservableField<String>()

    private val mainApiRepository: MainApiRepository

    init {
        mainApiRepository = MainApiRepository(application, mainApiInterface)
        this.searchText.set("")
    }

    fun search(searchStr: String): LiveData<SearchVenueResponse> {
        return mainApiRepository.searchVenues(searchStr)
    }

    fun go(search: String) {
        if (!search.isEmpty()) {
            getNavigator()?.onSearchGoClicked(search)
        } else {
            getNavigator()?.enterTextMessage()
        }
    }
}