package com.example.abnambrotest.networkinterface.remote.response.detail

import com.example.abnambrotest.networkinterface.remote.response.search.Categories
import com.example.abnambrotest.networkinterface.remote.response.search.Location
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by Darshan Patel
 * Usage: POJO class for response
 * How to call: retrofit will use this pojo for API Response for venue detail
 */
data class VenueResponse(
    @SerializedName("id")
    @Expose
    var id: String = "",
    @SerializedName("name")
    @Expose
    var name: String = "",
    @SerializedName("location")
    @Expose
    var location: Location,
    @SerializedName("categories")
    @Expose
    var categories: List<Categories>,
    @SerializedName("verified")
    @Expose
    var verified: Boolean,
    @SerializedName("url")
    @Expose
    var url: String = "",
    @SerializedName("rating")
    @Expose
    var rating: Double,
    @SerializedName("description")
    @Expose
    var description: String = ""
)