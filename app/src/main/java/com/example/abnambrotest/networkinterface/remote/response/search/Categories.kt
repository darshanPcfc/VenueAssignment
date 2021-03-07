package com.example.abnambrotest.networkinterface.remote.response.search

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by Darshan Patel
 * Usage: POJO class for response also categories table created in room for caching
 * How to call: retrofit will use this pojo for API Response for search venue
 */
@Entity(tableName = "categories_table")
data class Categories(
    @PrimaryKey
    val id: String = "",
    val name: String = "",
    val pluralName: String = "",
    val shortName: String = "",
    @Embedded
    val icon: Icon = Icon(),
    val primary: Boolean = false
)