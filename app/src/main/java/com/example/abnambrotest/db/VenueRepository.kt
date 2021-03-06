package com.example.abnambrotest.db

import androidx.lifecycle.LiveData
import com.example.abnambrotest.ni.remote.response.search.Venues

class VenueRepository(private val iVenueDao: IVenueDao) {
    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    val allVenues : LiveData<List<Venues>> = iVenueDao.getVenues()

    suspend fun insert(venues: Venues){
        iVenueDao.insert(venues)
    }
}