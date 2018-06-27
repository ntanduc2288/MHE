package com.interview.mhe.domain.utils;

import com.interview.mhe.data.retrofitService.responseEntity.UserEntity;
import com.interview.mhe.presentation.uiObjects.UserObject;
import java.util.ArrayList;
import java.util.List;

public class Mapper {

    public static UserObject mappingUserEntityToUserObject(UserEntity userEntity){
        UserObject userObject = new UserObject();
        userObject.setUserId(userEntity.getUserId());
        userObject.setBody(userEntity.getBody());
        userObject.setTitle(userEntity.getTitle());
        return userObject;
    }

    public static ArrayList<UserObject> mappingUserEntitiesToUsers(ArrayList<UserEntity> userEntities){
        ArrayList<UserObject> userObjects = new ArrayList<>();
        for (UserEntity userEntity : userEntities) {
            userObjects.add(mappingUserEntityToUserObject(userEntity));
        }
        return userObjects;
    }
}
