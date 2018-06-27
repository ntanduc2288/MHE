package com.interview.mhe.data.retrofitService;

import android.content.Context;

import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {
    /**
     * Retrofit with httpclient ssl and cace
     *
     * @param httpClient
     * @param context
     * @return
     */
    public Retrofit buildRetrofit(OkHttpClient httpClient, Context context) {
        final String baseUrl = APIConstant.BASE_URL;
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(httpClient)
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().serializeNulls().create()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }


}

