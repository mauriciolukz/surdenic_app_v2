package com.clov3rlabs.jensoft.surdenic.rest;


import android.content.Context;

import com.clov3rlabs.jensoft.surdenic.utils.ConnectivityInterceptor;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by rsaavedra on 23/7/2018.
 */

public class ApiClient {

    //public static final String BASE_URL = "http://apppedidos.infodet.edu.ni/api_jerp/";
    //public static final String BASE_URL = "http://surdenic.info/api_jerp/";
    public static final String BASE_URL = "http://mariachiaztecadeoro.com/api_surdenic_v2/";

    private static Retrofit retrofit = null;

    private static OkHttpClient getRequestHeader(Context context) {
        OkHttpClient httpClient = new OkHttpClient.Builder().connectTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(120, TimeUnit.SECONDS)
                .readTimeout(120, TimeUnit.SECONDS)
                .addInterceptor(new ConnectivityInterceptor(context))
                .build();
        return httpClient;
    }


    public static Retrofit getClient(Context mContext) {
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(getRequestHeader(mContext))
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }






}
