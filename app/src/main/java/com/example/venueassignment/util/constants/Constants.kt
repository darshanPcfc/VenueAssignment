package com.example.venueassignment.util.constants

/**
 * Created by Darshan Patel
 * Usage: all project constant
 */
object Constants {
    const val CRASHLYTICS_KEY_PRIORITY = "priority"
    const val CRASHLYTICS_KEY_TAG = "tag"
    const val CRASHLYTICS_KEY_MESSAGE = "message"
    const val VENUE_DATABASE = "venue_database"

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
            const val V_VALUE = "20210303"
        }
    }
}