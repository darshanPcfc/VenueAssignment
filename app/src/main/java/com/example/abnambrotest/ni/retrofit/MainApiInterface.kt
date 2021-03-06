package com.example.abnambrotest.ni.retrofit


import com.example.abnambrotest.ni.remote.response.MainApiResponse
import com.example.abnambrotest.ni.remote.response.detail.DetailVenueResponse
import com.example.abnambrotest.ni.remote.response.search.SearchVenueResponse
import com.example.abnambrotest.util.constants.Constants
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MainApiInterface {

    @GET(Constants.ApiEndpoints.MAIN_API)
    fun mainApiCall(): Call<MainApiResponse>

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