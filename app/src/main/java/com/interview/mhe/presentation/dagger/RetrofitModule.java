package com.interview.mhe.presentation.dagger;



import com.interview.mhe.App;
import com.interview.mhe.data.retrofitService.RetrofitApiService;
import com.interview.mhe.data.retrofitService.RetrofitService;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;

@Module
public class RetrofitModule {

    @Provides
    @Singleton
    public RetrofitService providesRetrofitService() {
        return new RetrofitService();
    }

    @Provides
    @Singleton
    public OkHttpClient provideHttpClient(App application) {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return new OkHttpClient.Builder().addInterceptor(loggingInterceptor)
                .connectTimeout(5, TimeUnit.MINUTES)
                .writeTimeout(5, TimeUnit.MINUTES)
                .readTimeout(5, TimeUnit.MINUTES)
                .build();
    }

    @Provides
    @Singleton
    public RetrofitApiService provideRetrofitApiService(RetrofitService retrofitService, OkHttpClient httpClient, App application) {
        Retrofit retrofit = retrofitService.buildRetrofit(httpClient, application);
        return retrofit.create(RetrofitApiService.class);
    }

    private OkHttpClient buildOkHttpClient(){
        return new OkHttpClient.Builder()
                .connectTimeout(5, TimeUnit.MINUTES)
                .writeTimeout(5, TimeUnit.MINUTES)
                .readTimeout(5, TimeUnit.MINUTES)
                .build();
    }
}
