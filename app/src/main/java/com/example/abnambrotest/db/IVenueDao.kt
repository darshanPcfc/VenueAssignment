package com.example.abnambrotest.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.abnambrotest.ni.remote.response.search.Venues

@Dao
interface IVenueDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(venues: Venues)

    @Query("SELECT * from venue_table")
    fun getVenues(): LiveData<List<Venues>>
}