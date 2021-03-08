package com.example.venueassignment.networkinterface.remote.response.detail

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by Darshan Patel
 * Usage: POJO class for response
 * How to call: retrofit will use this pojo for API Response for venue detail
 */
data class VenueDetailResponse(
    @SerializedName("venue")
    @Expose
    val venues: VenueResponse
)