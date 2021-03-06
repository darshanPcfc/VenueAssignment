package com.example.abnambrotest.ni.remote.response.detail

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class VenueDetailResponse(
    @SerializedName("venue")
    @Expose
    val venues: VenueResponse) {
}