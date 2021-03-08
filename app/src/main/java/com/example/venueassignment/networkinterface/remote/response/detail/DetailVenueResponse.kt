package com.example.venueassignment.networkinterface.remote.response.detail

import com.example.venueassignment.networkinterface.remote.response.search.Meta
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by Darshan Patel
 * Usage: POJO class for response
 * How to call: retrofit will use this pojo for API Response for venue detail
 */
data class DetailVenueResponse(
    @SerializedName("meta")
    @Expose
    var meta: Meta,
    @SerializedName("response")
    @Expose
    var response: VenueDetailResponse
)