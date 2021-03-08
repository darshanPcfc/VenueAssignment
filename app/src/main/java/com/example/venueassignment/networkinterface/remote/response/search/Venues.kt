package com.example.venueassignment.networkinterface.remote.response.search

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

/**
 * Created by Darshan Patel
 * Usage: POJO class for response also venue table created in room for caching
 * How to call: retrofit will use this pojo for API Response for search venue
 */
@Entity(tableName = "venue_table")
data class Venues(
    @ColumnInfo(name = "id")
    val id: String,
    @PrimaryKey
    @ColumnInfo(name = "name")
    val name: String,
    @Embedded
    var location: Location = Location(),
    val categories: List<Categories> = ArrayList(),
    @ColumnInfo(name = "referral_id")
    val referralId: String,
    val hasPerk: Boolean
) : Serializable