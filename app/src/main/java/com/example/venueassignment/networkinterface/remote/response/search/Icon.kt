package com.example.venueassignment.networkinterface.remote.response.search

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.RoomWarnings

/**
 * Created by Darshan Patel
 * Usage: POJO class for response also icon table created in room for caching
 * How to call: retrofit will use this pojo for API Response for search venue
 */
@SuppressWarnings(RoomWarnings.PRIMARY_KEY_FROM_EMBEDDED_IS_DROPPED)
@Entity(tableName = "icon_table")
data class Icon(
    @PrimaryKey
    val prefix: String = "",
    val suffix: String = ""
)