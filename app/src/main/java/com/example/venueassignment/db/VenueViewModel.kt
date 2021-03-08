package com.example.venueassignment.db

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.venueassignment.base.BaseApplication
import com.example.venueassignment.networkinterface.remote.response.search.Venues
import kotlinx.coroutines.launch
/**
 * Created by Darshan Patel
 * Usage: Model for all DB operation on venue table
 * creating coroutines and fetching values from VenueRepository from venue table
 * How to call: VenueViewModel(BaseApplication.instance!!)
 * Useful parameter: BaseApplication object to fetch DB Object
 */
class VenueViewModel(application: BaseApplication) : AndroidViewModel(application) {
    // The ViewModel maintains a reference to the repository to get data.
    private val repository: VenueRepository

    // LiveData gives us updated words when they change.
    val allVenues: LiveData<List<Venues>>

    init {
        // Gets reference to Venue from VenueDataSet to construct the correct VenueRepository.
        val venueDao = VenueDataSet.getDatabase(application).venueDao()
        repository = VenueRepository(venueDao)
        allVenues = repository.allVenues
    }

    /**
     * The implementation of insert() in the database is completely hidden from the UI.
     * Room ensures that you're not doing any long running operations on
     * the main thread, blocking the UI, so we don't need to handle changing Dispatchers.
     * ViewModels have a coroutine scope based on their lifecycle called
     * viewModelScope which we can use here.
     */
    fun insert(venues: Venues) = viewModelScope.launch {
        repository.insert(venues)
    }
}