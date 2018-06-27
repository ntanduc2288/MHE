package com.interview.mhe.domain;

import com.interview.mhe.presentation.uiObjects.UserObject;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;

public interface DataRepository {
    Observable<ArrayList<UserObject>> getUsers();
}
