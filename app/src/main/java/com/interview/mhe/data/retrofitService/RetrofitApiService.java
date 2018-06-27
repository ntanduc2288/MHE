package com.interview.mhe.data.retrofitService;

import com.interview.mhe.data.retrofitService.responseEntity.UserEntity;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface RetrofitApiService {

    @GET("posts")
    Observable<ArrayList<UserEntity>> getUsers();

}

