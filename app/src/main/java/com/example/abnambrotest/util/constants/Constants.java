package com.example.abnambrotest.util.constants;

public class Constants {
    public static final String CRASHLYTICS_KEY_PRIORITY = "priority";
    public static final String CRASHLYTICS_KEY_TAG = "tag";
    public static final String CRASHLYTICS_KEY_MESSAGE = "message";

    // Retrofit file cache name
    public static String retrofitCacheFile = "investerServiceCacheFile";

    public interface ApiEndpoints {
        String MAIN_API = "6c3je";
        String SEARCH_API = "search?";
        String DETAIL_API = "3fd66200f964a5209beb1ee3";
    }

    public interface SearchQueryParam{
        String CLIENT_ID_KEY = "client_id";
        String CLIENT_SECRET_KEY = "client_secret";
        String V_KEY = "v";
        String NEAR_KEY = "near";
        String CLIENT_ID_VALUE = "XAZF3HZTWX420MI1NIB5ZGM0FPZTS2ESZ4MR2ZF4CTUYUPWS";
        String CLIENT_SECRET_VALUE = "WJAOOFIKAL0SJ1ZRUM44Y24F4PMU1ZGKBVXPT1RUGF0P1NE1";
        String V_VALUE = "20210303";
    }

    public interface ApiFields {
        String CONTENT_TYPE = "application";
    }
}
