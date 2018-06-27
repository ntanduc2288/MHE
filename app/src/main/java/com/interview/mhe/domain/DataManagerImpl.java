package com.interview.mhe.domain;

import com.interview.mhe.App;
import com.interview.mhe.data.retrofitService.RetrofitApiService;
import com.interview.mhe.data.retrofitService.responseEntity.UserEntity;
import com.interview.mhe.domain.utils.Mapper;
import com.interview.mhe.presentation.uiObjects.UserObject;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public class DataManagerImpl implements DataRepository {

    @Inject
    RetrofitApiService retrofitApiService;

    public DataManagerImpl() {
        App.getComponent().inject(this);
    }

    private Observable<ArrayList<UserEntity>> getUsersInfoFromServer(){
        return retrofitApiService.getUsers().subscribeOn(Schedulers.newThread());
    }

    /**
     * get users from server then convert it to UI object.
     * Just in case server changes data format or something like that, it will be not affected to the UI code.
     * @return
     */
    @Override
    public Observable<ArrayList<UserObject>> getUsers() {
        return getUsersInfoFromServer()
                .map(userEntity -> Mapper.mappingUserEntitiesToUsers(userEntity));
    }
}
