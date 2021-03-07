package com.example.abnambrotest.networkinterface.remote.response.search

/**
 * Created by Darshan Patel
 * Usage: POJO class for response also categories table created in room for caching
 * How to call: retrofit will use this pojo for API Response for search venue
 */
data class Response(val venues: ArrayList<Venues>)