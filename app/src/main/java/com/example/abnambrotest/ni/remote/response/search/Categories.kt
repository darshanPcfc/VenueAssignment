package com.example.abnambrotest.ni.remote.response.search

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

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
) {
}