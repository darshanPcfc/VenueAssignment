package com.example.abnambrotest.ui.fragment.detailfragment

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.abnambrotest.base.BaseViewModel
import com.example.abnambrotest.ni.remote.response.detail.DetailVenueResponse
import com.example.abnambrotest.ni.repository.VenueDetailRepository
import com.example.abnambrotest.ni.retrofit.MainApiInterface

class DetailViewModel(application: Application, val mainApiInterface: MainApiInterface) :
    BaseViewModel<IDetailNavigator>() {

    private val venueDetailRepository : VenueDetailRepository

    init {
        venueDetailRepository = VenueDetailRepository(application, mainApiInterface)
    }

    fun detailVenue(venueID: String): LiveData<DetailVenueResponse> {
        return venueDetailRepository.searchVenues(venueID)
    }

}