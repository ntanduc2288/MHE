package com.interview.mhe.presentation.ui.userList;

import com.interview.mhe.presentation.uiObjects.UserObject;

import java.util.ArrayList;

public interface UserListPresenter {
    interface View{
        void showLoading();
        void hideLoading();
        void showMessage(String message);
        void initUserListView();
        void bindUsersToUI(ArrayList<UserObject> userObjects);
        void gotoUserDetailScreen(UserObject userObject);
    }

    interface Presenter{
        void triggerLoadUserDatas();
        void release();
    }
}
