package com.example.venueassignment.networkinterface.repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.venueassignment.BuildConfig
import com.example.venueassignment.networkinterface.remote.response.detail.DetailVenueResponse
import com.example.venueassignment.networkinterface.retrofit.MainApiInterface
import com.example.venueassignment.networkinterface.retrofit.RetrofitGenericResponse
import com.example.venueassignment.networkinterface.retrofit.RetrofitResponseCallback
import com.example.venueassignment.util.constants.Constants
import retrofit2.Response

/**
 * Created by Darshan Patel
 * Usage: Repository to call API
 * How to call: create a instance and pass instance of your API interface and pass your context
 * Useful parameter: mainApiInterceptor as required to call retrofit
 */
class VenueDetailRepository(
    private val context: Context,
    val mainApiInterceptor: MainApiInterface
) {
    fun searchVenues(venueID: String): LiveData<DetailVenueResponse> {
        val data = MutableLiveData<DetailVenueResponse>()

        RetrofitGenericResponse.callRetrofit(mainApiInterceptor.venueDetail(
            venueID,
            BuildConfig.CLIENT_ID_KEY_VALUE,
            BuildConfig.CLIENT_SECRET_KEY_VALUE,
            Constants.SearchQueryParam.V_VALUE
        ), object :
            RetrofitResponseCallback {
            override fun success(response: Response<*>) {
                if (response.body() != null) {
                    data.value = response.body() as DetailVenueResponse
                }
            }

            override fun error(error: String) {
                data.value = null
            }

            override fun failure(message: String) {
                data.value = null
            }
        })
        return data
    }
}