package com.example.abnambrotest.networkinterface.remote.response.search

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.RoomWarnings

/**
 * Created by Darshan Patel
 * Usage: POJO class for response also location table created in room for caching
 * How to call: retrofit will use this pojo for API Response for search venue
 */
@SuppressWarnings(RoomWarnings.PRIMARY_KEY_FROM_EMBEDDED_IS_DROPPED)
@Entity(tableName = "location_table")
data class Location(
    var address: String = "",
    var crossStreet: String = "",
    var lat: Double = 0.0,
    var lng: Double = 0.0,
    var distance: Int = 0,
    @PrimaryKey
    var postalCode: String = "",
    var cc: String = "",
    var neighborhood: String = "",
    var city: String = "",
    var state: String = "",
    var country: String = ""
)