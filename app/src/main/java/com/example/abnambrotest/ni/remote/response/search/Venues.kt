package com.example.abnambrotest.ni.remote.response.search

import androidx.annotation.NonNull
import androidx.room.*

@Entity(tableName = "venue_table")
data class Venues(
    @NonNull
    @ColumnInfo(name = "id")
    val id: String,
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "name")
    val name: String,
    @Embedded
    var location: Location = Location(),
    /*val categories: List<Categories> = ArrayList(),*/
    @NonNull
    @ColumnInfo(name = "referral_id")
    val referralId: String,
    val hasPerk: Boolean)