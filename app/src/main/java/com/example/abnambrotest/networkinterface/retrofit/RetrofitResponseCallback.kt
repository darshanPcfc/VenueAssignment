package com.example.abnambrotest.networkinterface.retrofit;

import retrofit2.Response;

/**
 * Created by Darshan Patel
 * Usage: general response for every API
 */
public interface RetrofitResponseCallback {
    void success(Response response);

    void error(String error);

    void failure(String message);
}
