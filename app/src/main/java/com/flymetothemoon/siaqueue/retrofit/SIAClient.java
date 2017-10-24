package com.flymetothemoon.siaqueue.retrofit;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by nhatton on 10/23/17.
 */

public class SIAClient {
    /********
     * URLS
     *******/
    private static final String ROOT_URL = "https://apidev.singaporeair.com/appchallenge/";

    /**
     * Get Retrofit Instance
     */
    private static Retrofit getRetrofitInstance() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .build();

        return new Retrofit.Builder()
                .baseUrl(ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
    }

    /**
     * Get API Service
     *
     * @return API Service
     */
    public static SIAService getApiService() {
        return getRetrofitInstance().create(SIAService.class);
    }
}
