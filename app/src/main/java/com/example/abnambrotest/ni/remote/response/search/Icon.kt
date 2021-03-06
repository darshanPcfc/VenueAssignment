package com.example.abnambrotest.ni.remote.response.search

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.RoomWarnings

@SuppressWarnings(RoomWarnings.PRIMARY_KEY_FROM_EMBEDDED_IS_DROPPED)
@Entity(tableName = "icon_table")
data class Icon(
    @PrimaryKey
    val prefix: String = "",
    val suffix: String = ""
) {
}