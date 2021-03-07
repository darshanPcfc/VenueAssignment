package com.example.abnambrotest.networkinterface.remote.response.search

import com.google.gson.annotations.SerializedName

/**
 * Created by Darshan Patel
 * Usage: POJO class for response
 * How to call: retrofit will use this pojo for API Response for search venue
 */
data class Meta(
    @SerializedName("code")
    val code: Int,
    @SerializedName("requestID")
    val requestID: String
)