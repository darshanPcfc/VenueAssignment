package com.example.abnambrotest.networkinterface.remote.response.search
/**
 * Created by Darshan Patel
 * Usage: POJO class for response
 * How to call: retrofit will use this pojo for API Response for search venue
 */
data class LabeledLatLngs(
    val label: String,
    val lat: Double,
    val lng: Double
)