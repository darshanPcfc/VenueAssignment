package com.example.abnambrotest.ni.repository

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.abnambrotest.ni.remote.response.detail.DetailVenueResponse
import com.example.abnambrotest.ni.retrofit.MainApiInterface
import com.example.abnambrotest.ni.retrofit.RetrofitGenericResponse
import com.example.abnambrotest.ni.retrofit.RetrofitResponseCallback
import com.example.abnambrotest.util.constants.Constants
import retrofit2.Response

class VenueDetailRepository(private val context: Context, val mainApiInterceptor: MainApiInterface) {
    fun searchVenues(venueID : String): LiveData<DetailVenueResponse> {
        val data = MutableLiveData<DetailVenueResponse>()

        RetrofitGenericResponse.callRetrofit(mainApiInterceptor.venueDetail(
            venueID,
            Constants.SearchQueryParam.CLIENT_ID_VALUE,
            Constants.SearchQueryParam.CLIENT_SECRET_VALUE,
            Constants.SearchQueryParam.V_VALUE
        ), object :
            RetrofitResponseCallback {
            override fun success(response: Response<*>) {
                if (response.body() != null) {
                    //println(response.body().toString())
                    Log.d("_Repo","Success Data" + response.body())
                    data.value = response.body() as DetailVenueResponse
                    Log.d("_DetailRepo","Success Data" + data.value)
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