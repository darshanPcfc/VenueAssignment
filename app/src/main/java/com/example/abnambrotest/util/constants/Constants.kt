package com.example.abnambrotest.util.constants

/**
 * Created by Darshan Patel
 * Usage: all project constant
 */
object Constants {
    const val CRASHLYTICS_KEY_PRIORITY = "priority"
    const val CRASHLYTICS_KEY_TAG = "tag"
    const val CRASHLYTICS_KEY_MESSAGE = "message"

    // Retrofit file cache name
    var retrofitCacheFile = "investerServiceCacheFile"

    interface ApiEndpoints {
        companion object {
            const val SEARCH_API = "search?"
        }
    }

    interface SearchQueryParam {
        companion object {
            const val CLIENT_ID_KEY = "client_id"
            const val CLIENT_SECRET_KEY = "client_secret"
            const val V_KEY = "v"
            const val NEAR_KEY = "near"
            const val CLIENT_ID_VALUE = "XAZF3HZTWX420MI1NIB5ZGM0FPZTS2ESZ4MR2ZF4CTUYUPWS"
            const val CLIENT_SECRET_VALUE = "WJAOOFIKAL0SJ1ZRUM44Y24F4PMU1ZGKBVXPT1RUGF0P1NE1"
            const val V_VALUE = "20210303"
        }
    }
}