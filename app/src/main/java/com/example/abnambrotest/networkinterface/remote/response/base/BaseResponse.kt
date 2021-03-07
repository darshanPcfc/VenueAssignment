package com.example.abnambrotest.networkinterface.remote.response.base

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by Darshan Patel
 * API Base response parse here
 */

open class BaseResponse {

    @SerializedName("ok")
    @Expose
    var okStatus: Boolean = false
}
