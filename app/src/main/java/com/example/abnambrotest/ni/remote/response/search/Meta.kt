package com.example.abnambrotest.ni.remote.response.search

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Meta(
    @SerializedName("code")
    val code: Int,
    @SerializedName("requestID")
    val requestID: String
)