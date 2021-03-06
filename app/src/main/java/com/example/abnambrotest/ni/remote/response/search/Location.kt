package com.example.abnambrotest.ni.remote.response.search

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.RoomWarnings

@SuppressWarnings(RoomWarnings.PRIMARY_KEY_FROM_EMBEDDED_IS_DROPPED)
@Entity(tableName = "location_table")
data class Location(var address: String = "",
                    var crossStreet: String = "",
                    var lat: Double = 0.0,
                    var lng: Double = 0.0,
                    var distance: Int = 0,
                    @PrimaryKey
                    var postalCode: String ="",
                    var cc: String = "",
                    var neighborhood: String = "",
                    var city: String = "",
                    var state: String = "",
                    var country: String = "") {
}