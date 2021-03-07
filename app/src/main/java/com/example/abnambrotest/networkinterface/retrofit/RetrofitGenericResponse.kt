package com.example.abnambrotest.networkinterface.retrofit;


import com.example.databindingdemo.util.log.CustomLogger;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Darshan Patel
 * Usage: Retrofit call
 * How to call: RetrofitGenericResponse(yourAPIInterFace,ResponsePOJOClass)
 */
public class RetrofitGenericResponse {
    private static String TAG = RetrofitGenericResponse.class.getSimpleName();

    public static <T> void callRetrofit(Call<T> call, final RetrofitResponseCallback retrofitResponseCallback) {

        call.enqueue(new Callback<T>() {
            @Override
            public void onResponse(Call<T> call, Response<T> response) {

                if (response.raw().networkResponse() != null) {
                    CustomLogger.INSTANCE.d(TAG, "onResponse: response is from NETWORK...");
                    if (response.isSuccessful()) {
                        retrofitResponseCallback.success(response);
                    } else {
                        try {
                            retrofitResponseCallback.error(response.errorBody().string());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                } else if (response.raw().cacheResponse() != null
                        && response.raw().networkResponse() == null) {
                    if (response.isSuccessful()) {
                        retrofitResponseCallback.success(response);
                    } else {
                        try {
                            retrofitResponseCallback.error(response.errorBody().string());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                } else {
                    retrofitResponseCallback.error("");
                }
            }

            @Override
            public void onFailure(Call<T> call, Throwable t) {
                retrofitResponseCallback.failure(t.toString());
            }
        });
    }
}
