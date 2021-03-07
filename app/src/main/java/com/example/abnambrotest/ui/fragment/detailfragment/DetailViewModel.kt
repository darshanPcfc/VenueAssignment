package com.example.abnambrotest.ui.fragment.detailfragment

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.abnambrotest.base.BaseViewModel
import com.example.abnambrotest.networkinterface.remote.response.detail.DetailVenueResponse
import com.example.abnambrotest.networkinterface.repository.VenueDetailRepository
import com.example.abnambrotest.networkinterface.retrofit.MainApiInterface
/**
 * Created by Darshan Patel
 * Usage: ViewModel for DetailFragment
 * Useful parameter: appcontext and api interface instance extend your base viewmodel and pass your navigator
 */

class DetailViewModel(application: Application, val mainApiInterface: MainApiInterface) :
    BaseViewModel<IDetailNavigator>() {

    private val venueDetailRepository: VenueDetailRepository

    init {
        venueDetailRepository = VenueDetailRepository(application, mainApiInterface)
    }

    fun detailVenue(venueID: String): LiveData<DetailVenueResponse> {
        return venueDetailRepository.searchVenues(venueID)
    }

}