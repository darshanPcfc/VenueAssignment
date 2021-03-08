package com.example.venueassignment.networkinterface.remote.response.search

/**
 * Created by Darshan Patel
 * Usage: POJO class for response
 * How to call: retrofit will use this pojo for API Response for search venue
 */
data class SearchVenueResponse(
    val meta: Meta,
    val response: Response
)