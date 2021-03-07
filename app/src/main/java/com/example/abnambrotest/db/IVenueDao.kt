package com.example.abnambrotest.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.abnambrotest.networkinterface.remote.response.search.Venues
/**
 * Created by Darshan Patel
 * Usage: DAO interface to insert data in room db or fetch any data
 * All DB query operation on room for venue table shoud be included here
 * How to call: implement this interface
 */
@Dao
interface IVenueDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(venues: Venues)

    @Query("SELECT * from venue_table")
    fun getVenues(): LiveData<List<Venues>>
}