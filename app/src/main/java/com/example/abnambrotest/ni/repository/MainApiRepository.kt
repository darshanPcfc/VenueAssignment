package com.example.abnambrotest.ni.repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.abnambrotest.ni.remote.request.MainApiRequest
import com.example.abnambrotest.ni.remote.response.MainApiResponse
import com.example.abnambrotest.ni.remote.response.search.SearchVenueResponse
import com.example.abnambrotest.ni.retrofit.MainApiInterface
import com.example.abnambrotest.ni.retrofit.RetrofitGenericResponse
import com.example.abnambrotest.ni.retrofit.RetrofitResponseCallback
import com.example.abnambrotest.util.constants.Constants
import com.google.gson.Gson
import retrofit2.Response

class MainApiRepository(private val context: Context, val mainApiInterceptor: MainApiInterface) {
    fun searchVenues(searchStr : String): LiveData<SearchVenueResponse> {
        val data = MutableLiveData<SearchVenueResponse>()

        RetrofitGenericResponse.callRetrofit(mainApiInterceptor.search(
            Constants.SearchQueryParam.CLIENT_ID_VALUE,
            Constants.SearchQueryParam.CLIENT_SECRET_VALUE,
            Constants.SearchQueryParam.V_VALUE,
            searchStr
        ), object :
            RetrofitResponseCallback {
            override fun success(response: Response<*>) {
                if (response.body() != null) {
                    //println(response.body().toString())
                    data.value = response.body() as SearchVenueResponse
                    println(data.value)
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

    companion object {
        private val TAG = MainApiRepository::class.java.simpleName
    }
}