package com.example.abnambrotest.ni.remote.response.detail

import com.example.abnambrotest.ni.remote.response.search.Meta
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class DetailVenueResponse(
    @SerializedName("meta")
    @Expose
    var meta: Meta,
    @SerializedName("response")
    @Expose
    var response: VenueDetailResponse
) {
}