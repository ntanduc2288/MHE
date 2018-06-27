package com.interview.mhe.presentation.ui.userDetail;

import android.content.Context;

import com.interview.mhe.presentation.uiObjects.UserObject;

public interface UserDetailPresenter {
    interface View{
        void showMessage(String message);
        void bindUserDataToView(UserObject userObject);
        Context getContext();
    }

    interface Presenter{
        void handleUserData(UserObject userObject);
        void release();
    }
}
