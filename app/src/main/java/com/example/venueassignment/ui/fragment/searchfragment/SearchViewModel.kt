package com.example.venueassignment.ui.fragment.searchfragment

import android.app.Application
import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import com.example.venueassignment.base.BaseViewModel
import com.example.venueassignment.networkinterface.remote.response.search.SearchVenueResponse
import com.example.venueassignment.networkinterface.repository.MainApiRepository
import com.example.venueassignment.networkinterface.retrofit.MainApiInterface

/**
 * Created by Darshan Patel
 * Usage: ViewModel for SearchFragment
 * Useful parameter: appcontext and api interface instance extend your base viewmodel and pass your navigator
 */
class SearchViewModel(application: Application, mainApiInterface: MainApiInterface) :
    BaseViewModel<ISearchNavigator>() {

    val searchText = ObservableField<String>()
    private val mainApiRepository: MainApiRepository

    init {
        mainApiRepository = MainApiRepository(application, mainApiInterface)
        this.searchText.set("")
    }

    fun search(searchStr: String): LiveData<SearchVenueResponse> {
        return mainApiRepository.searchVenues(searchStr)
    }

    fun go(search: String) {
        if (search.isNotEmpty()) {
            getNavigator()?.onSearchGoClicked(search)
        } else {
            getNavigator()?.enterTextMessage()
        }
    }
}