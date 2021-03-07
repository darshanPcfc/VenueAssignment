package com.example.abnambrotest.db

import androidx.lifecycle.LiveData
import com.example.abnambrotest.networkinterface.remote.response.search.Venues
/**
 * Created by Darshan Patel
 * Usage: Repository for all DB operation on venue table
 * How to call: pass daoObject when you initiate your repository obejct
 * Useful parameter: IVenueDao reference object to access interface methods
 */
class VenueRepository(private val iVenueDao: IVenueDao) {
    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    val allVenues: LiveData<List<Venues>> = iVenueDao.getVenues()

    //insert into table venue suspended function cause coroutines are accessing this function
    suspend fun insert(venues: Venues) {
        iVenueDao.insert(venues)
    }
}