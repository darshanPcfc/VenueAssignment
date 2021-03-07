package com.example.abnambrotest.networkinterface.retrofit

import com.example.abnambrotest.networkinterface.remote.response.detail.DetailVenueResponse
import com.example.abnambrotest.networkinterface.remote.response.search.SearchVenueResponse
import com.example.abnambrotest.util.constants.Constants
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by Darshan Patel
 * Usage: list down all api here with endpoints and request and query parameter
 */
interface MainApiInterface {

    @GET(Constants.ApiEndpoints.SEARCH_API)
    fun search(
        @Query(Constants.SearchQueryParam.CLIENT_ID_KEY) strClientIDKey: String,
        @Query(Constants.SearchQueryParam.CLIENT_SECRET_KEY) strClientSecret: String,
        @Query(Constants.SearchQueryParam.V_KEY) version: String,
        @Query(Constants.SearchQueryParam.NEAR_KEY) searchText: String
    ): Call<SearchVenueResponse>

    @GET("{venueId}?")
    fun venueDetail(
        @Path("venueId") venueId: String,
        @Query(Constants.SearchQueryParam.CLIENT_ID_KEY) strClientIDKey: String,
        @Query(Constants.SearchQueryParam.CLIENT_SECRET_KEY) strClientSecret: String,
        @Query(Constants.SearchQueryParam.V_KEY) version: String
    ): Call<DetailVenueResponse>
}